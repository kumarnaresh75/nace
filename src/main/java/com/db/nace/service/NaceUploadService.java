package com.db.nace.service;

import com.db.nace.dto.NaceDto;
import com.db.nace.entity.Nace;
import com.db.nace.repository.NaceRepository;
import com.db.nace.util.NaceUtils;
import com.db.nace.util.StreamUtil;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class NaceUploadService {

    @Autowired
    private StreamUtil streamUtil;

    @Autowired
    NaceUtils naceUtils;
    @Autowired
    private NaceRepository naceRepository;

    public void upload(MultipartFile file) throws IOException {


        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Supplier<Stream<Row>> rowStreamSupplier = streamUtil.getRowsStreamSupplier(sheet);

        Row headerRow = rowStreamSupplier.get().findFirst().get();
        List<String> headerColNames = StreamSupport.stream(headerRow.spliterator(), false)
                .map(Cell::getStringCellValue)
                .collect(Collectors.toList());

        System.out.println(headerColNames);

        List<NaceDto> dtoList = new ArrayList<>();
        rowStreamSupplier.get().skip(1)
                //.limit(5)
                .forEach(
                row ->{
                    NaceDto naceDto = processRow(row);
                    dtoList.add(naceDto);
                }

        );

        dtoList.forEach(System.out::println);
        System.out.println("Count: "+dtoList.size());

        persist(dtoList);


    }

    private NaceDto processRow(Row row) {

        NaceDto naceDto = new NaceDto();
        for (int i = 0; i < 9 ; i++) {
            Cell cell = row.getCell(i);

            if(row.getCell(i)==null)
                continue;

            String cellValStr = getStringCellValue(cell);
            switch (i) {
                case 0:
                    naceDto.setOrderNum(cellValStr);
                    break;
                case 1:
                    naceDto.setLevel(cellValStr);
                    break;
                case 2:
                    naceDto.setCode(cellValStr);
                    break;
                case 3:
                    naceDto.setParent(cellValStr);
                    break;
                case 4:
                    naceDto.setDescription(cellValStr);
                    break;
                case 5:
                    naceDto.setItemIncludes(cellValStr);
                    break;
            }
        }

        return naceDto;
    }

    private String getStringCellValue(Cell cell) {
        if (cell.getCellType().equals(CellType.NUMERIC)) {
            return String.valueOf(cell.getNumericCellValue());
        } else if (cell.getCellType().equals(CellType.STRING)) {
            return cell.getStringCellValue();
        }
        else
            return null;
    }

    private void persist(List<NaceDto> dtoList) {
        List<Nace> entityList = naceUtils.convertToEntity(dtoList);
        naceRepository.saveAll(entityList);
    }
    public NaceDto findByOrderNum(String orderNum) {

        Nace naceEntity = naceRepository.findByOrderNum(Long.valueOf(orderNum));
        return naceUtils.convertToDto(naceEntity);
    }
}

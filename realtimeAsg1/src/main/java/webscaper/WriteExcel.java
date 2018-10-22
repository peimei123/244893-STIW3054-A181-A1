package webscaper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class WriteExcel {
    public static void main() throws IOException {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Trivia Table");

            int num=0;

            for (Info info : webscaper.WebTableHandle.findAll()) {
                Row row = sheet.createRow(num);

                Cell cellCharacter = row.createCell(0);
                cellCharacter.setCellValue(info.getCharacteristic());

                Cell cellInfo = row.createCell(1);
                cellInfo.setCellValue(info.getInformation());

                num++;

                if (num==0 && num<2){
                    sheet.autoSizeColumn(num);
                }
            }

            FileOutputStream output = new FileOutputStream(new File("C:\\realtimeAsg1\\Trivia.xls"));
            workbook.write(output);
            output.close();
            workbook.close();
            System.out.println("Info written!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

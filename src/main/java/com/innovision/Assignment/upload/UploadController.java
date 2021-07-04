package com.innovision.Assignment.upload;

import com.innovision.Assignment.entity.Show;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
@RestController
public class UploadController {

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String hello()
    {
        return "hello";
    }




    String path = "C:\\Users\\prane\\Desktop\\netflix_excel.xlsx";
    @RequestMapping(value="/upload",method = RequestMethod.GET)
    public boolean upload()
    {
        File f = new File(path);
        try
        {
            FileInputStream file = new FileInputStream(f);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            int count = 0;
            rowIterator.next(); //skip the header
            //File  opened
            //rowIterator.hasNext()
            for(int i =0;i<3;i++)
            {
                //Show show  = new Show();
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                String movieId = " ";
                Boolean type = false;
                String title = "";
                String director = "";
                String[] cast = null;
                String county = " ";
                Integer releaseYear = 0;
                String rating = " ";
                String duration = " ";
                String listedIn = " ";
                String description = " ";
                //while(cellIterator.hasNext())
                while(cellIterator.hasNext())
                {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();
                    switch(columnIndex)
                    {
                        case 0:
                            //show_id
                            movieId = nextCell.getStringCellValue();
                            System.out.println(movieId);
                            break;

                        case 1:
                            String typet = nextCell.getStringCellValue();
                            if(typet.equals("Movie"))
                                type = false;
                            else
                                type = true;
                            System.out.println(type);
                            break;
                        case 2:
                            title = nextCell.getStringCellValue();
                            System.out.println(title);
                            break;
                        case 3:
                            director = nextCell.getStringCellValue();
                            System.out.println(director);
                            break;
                        case 4:
                            String tempcast = nextCell.getStringCellValue();

                            cast = tempcast.split(",");
                            for(String s : cast)
                            {
                                System.out.print(s+" ");
                            }
                            break;
                        case 5:
                            String country = nextCell.getStringCellValue();
                            System.out.println(country);
                            break;
                        case 6:
                            releaseYear = (int) nextCell.getNumericCellValue();
                            System.out.println(releaseYear);
                            break;
                        case 7:
                            rating = nextCell.getStringCellValue();
                            System.out.println(rating);
                            break;
                        case 8:
                            duration = nextCell.getStringCellValue();
                            System.out.println(duration);
                            break;
                        case 9:
                            listedIn = nextCell.getStringCellValue();
                            System.out.println(listedIn);
                            break;
                        case 10:
                            description = nextCell.getStringCellValue();
                            System.out.println(description);
                            break;

                    }

                    //System.out.println(movieId+type+title+director+cast+county+releaseYear+rating+duration+listedIn+description);
                }

                System.out.println("**********************");





            }
            return true;

        }
        catch (Exception e)
        {
                e.printStackTrace();
                return false;
        }
    }

}

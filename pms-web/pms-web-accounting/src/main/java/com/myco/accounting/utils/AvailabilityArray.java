
package lib;

//import java.sql.Date;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import beans.AvailabilityDay;

public class AvailabilityArray {

    private short DAYS=90;
    private String[] roomTypes = {"ES","SJ"}; // debe ser cargado en el objeto "llamador"

    private java.sql.Date[] daysOcc;
    private int[][]         roomsOcc=null;
    private int[]           totalDayOcc=null;
    private String[][]      availability=null;

    private int dayIndex=0;

    private java.sql.Date  sqlStartDate=null;
    private java.sql.Date  sqlEndDate=null;
    private Calendar cal = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");

    private String period, textStartDate;

    public AvailabilityArray(){}

    public AvailabilityArray(String textStartDate, String period){
        int roomsOccLength = 0;
        this.period = period;
        this.textStartDate = textStartDate;

        daysOcc  = new java.sql.Date[DAYS];
        roomsOccLength = daysOcc.length + 1;
        /* se adiciona un campo mas para almacenar el total por tipo */
        roomsOcc = new int[roomTypes.length][roomsOccLength];
        /* se adiciona un campo mas para almacenar la suma del total por tipo */
        totalDayOcc = new int[roomsOccLength];
        /* se adicionan dos campos mas para la cabecera y el pie (total) */
        availability = new String[roomTypes.length + 2][getNumberColumns() + 2];
        chargeDaysOcc();
    }

    public void chargeDaysOcc(){
        java.util.Date utilStartDate=null;
        try{
          utilStartDate = sdf.parse(textStartDate);
          cal.setTime(utilStartDate);
        }catch(Exception e){};

        for(int i=0; i < daysOcc.length; i++){
          daysOcc[i] = new java.sql.Date(cal.getTimeInMillis());
          cal.add(cal.DAY_OF_MONTH, 1);
        }

        sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        sqlEndDate   = new java.sql.Date(daysOcc[daysOcc.length - 1].getTime());
    }

    public java.sql.Date getStartDate(){
        return sqlStartDate;
    }

    public java.sql.Date getEndDate(){
        return sqlEndDate;
    }

    public void setNextWeek(){
        cal.add(cal.WEEK_OF_MONTH, 1);
     }

    /** Carga los elementos de cada arreglo
    * @param list
    */
    public void chargeRoomsOccupation(ArrayList list){
        AvailabilityDay ad = new AvailabilityDay();
/* revisa cada elemento de la lista */
        for(int idx=0; idx < list.size(); idx++){
          ad = (AvailabilityDay)list.get(idx);
/* ubica el tipo de habitacion */
          for(int i=0; i < roomTypes.length; i++){
            //System.out.println(i+" "+ad.getRoomType());
            if(roomTypes[i].equals(ad.getRoomType())){
/* una vez determinado el tipo de habitacion, ubica el dia  */
              for(int j=0; j < daysOcc.length; j++){
                //System.out.println(j+" "+ad.getOccupiedDay()+" "+ad.getOccupiedRooms());
                if(daysOcc[j].equals(ad.getOccupiedDay())){
                  roomsOcc[i][j] = ad.getOccupiedRooms();
/* acumula el total por dia */
                  totalDayOcc[j] += ad.getOccupiedRooms();
                  break;
                }
              }
            }
            //break;
          }
        }
     }

    /** Carga la matriz que sera devuelta a CtrlAvailability
    * @param none
    */
    public String[][] getAvailabilityArray(){
        int totalRoomType=0, totalHotel=0;
        int avaColLength = availability[0].length;
        /* Charge Room Types */
        for(int i=0; i < roomTypes.length; i++)
          availability[i+1][0] = roomTypes[i];
        /* Charge Occupied Date */
        for(int i=0,idx=dayIndex; i < avaColLength - 2 && idx < daysOcc.length; i++,idx++)
          availability[0][i+1] = String.valueOf(daysOcc[idx]);
        /* Charge Occupied Rooms */
        for(int i=0; i < availability.length - 2; i++){
          for(int j=0,idx=dayIndex; j < avaColLength - 2 && idx < roomsOcc[0].length; j++,idx++){
            availability[i+1][j+1] = String.valueOf(roomsOcc[i][idx]);
            totalRoomType += roomsOcc[i][idx];
          }
          availability[i+1][avaColLength - 1]
                        = String.valueOf(totalRoomType);
          totalHotel += totalRoomType;
          totalRoomType = 0;
        }
        /* Charge Occupied Rooms by Day */
        for(int i=0,idx=dayIndex; i < avaColLength - 2 && idx < totalDayOcc.length; i++,idx++){
          availability[availability.length - 1][i+1] = String.valueOf(totalDayOcc[idx]);
          dayIndex = idx;
        }
        availability[availability.length - 1][avaColLength - 1]
                    = String.valueOf(totalHotel);

        return availability;
    }

    private int getNumberColumns(){
        char[] periodChar = period.toCharArray();
        int numberColumns=0;

        switch(periodChar[0]){
          case 'W': numberColumns =  7; break; // A WEEK
          case 'M': numberColumns = 30; break; // A MONTH
          case 'Q': numberColumns = 12; break; // A QUARTER = 12 WEEKS
          case 'S': numberColumns =  6; break; // A SIX MONTH
          case 'Y': numberColumns = 12; break; // A YEAR = 12 MONTHS
          case 'B': numberColumns = 24; break; // A TWO YEAR = 24 MONTHS
          default:  numberColumns =  7; break; // A WEEK
        }
        return numberColumns;
    }

}
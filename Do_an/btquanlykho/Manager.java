
package btquanlykho;

import java.util.Calendar;
import java.util.Date;

public class Manager {
    
    public Date ngayXuat;
    
    public Date xuat(int day,int month,int year){
        Calendar cl = Calendar.getInstance();
        cl.set(year, month-1, day);
        return this.ngayXuat=cl.getTime();
    }
}

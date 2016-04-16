/*
 * MonthTest.java
 *
 * Created on 26 de julio de 2007, 15:30
 */

package libraries;

/**
 *
 * @author Developer
 */
public class MonthTest {
    
    Month m;
    /** Creates a new instance of MonthTest */
    public MonthTest() {
    }
    
    public static void main(String[] args) {
        for ( Month m : Month.values() ) {
            System.out.println( m.toString() );
        }
        /*for ( Month m : Month.values() ) {
            System.out.println(m.toString());
        }*/
    }
}

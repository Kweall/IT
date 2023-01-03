import java.util.Scanner;

class Lab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double newArr[] = new double[9];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = sc.nextDouble();
        }
        Point3d a = new Point3d(newArr[0], newArr[1], newArr[2]);
        Point3d b = new Point3d(newArr[3], newArr[4], newArr[5]);
        Point3d c = new Point3d(newArr[6], newArr[7], newArr[8]);
        /*Point3d a = new Point3d(1, 2, 3);
        Point3d b = new Point3d(2, 4, 5);
        Point3d c = new Point3d(3, 5, 6);*/
        //System.out.println(a.distanceTo(b));   
        System.out.println(computeArea(a, b, c));    
    }

    public static double computeArea(Point3d a, Point3d b, Point3d c) {
       
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double ac = a.distanceTo(c);
        double p = 0.5 * (ab + bc + ac);
        return Math.ceil(Math.sqrt(p*(p-ab)*(p-bc)*(p-ac)) * Math.pow(10, 2)) / Math.pow(10, 2);
    }

}

package Q16_03_Intersection;

public class Question {

    public static boolean isBetween(double start, double middle, double end){
        if(start < end){
            return start <= middle && end >= middle;
        }else{
            return start >= middle && end <= middle;
        }
    }

    public static boolean isBetween(Point start, Point middle, Point end){
        return isBetween(start.x,middle.x,end.x) && isBetween(start.y,middle.y,end.y);
    }


    public static Point intersection(Point s1, Point e1, Point s2, Point e2) {
        Line line1 = new Line(s1,e1);
        Line line2 = new Line(s2,e2);

        if(line1.slope == line2.slope){ // parallel
            if(line1.yintercept != line2.yintercept) return null;

            if(isBetween(s1,s2,e1)) return s2;
            else if(isBetween(s1,e2,e1)) return e2;
            else if(isBetween(s2,s1,e2)) return s1;
            else if(isBetween(s2,e1,e2)) return e1;

            return null;
        }

        // not parallel
        double intersectionX = 0;
        if(line1.isVertical() || line2.isVertical()){
            intersectionX = line1.isVertical() ? line1.start.x : line2.start.x;
        }else{
            intersectionX = (line2.yintercept-line1.yintercept) / (line1.slope-line2.slope);
        }
        double intersectionY = line1.isVertical() ? line2.getYFromX(intersectionX) : line1.getYFromX(intersectionX);

        Point intersection = new Point(intersectionX,intersectionY);
        if(isBetween(s1, intersection, e1) && isBetween(s2, intersection, e2)){
            return intersection;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {

		Point s1 = new Point(2147000000, 1);
		Point e1 = new Point(-2147000000, -1);
		Point s2 = new Point(-10, 0);
		Point e2 = new Point(0, 0);
		Point intersection = intersection(s1, e1, s2, e2);
		System.out.println("Line Segment 1: " + s1 + " to " + e1);
		System.out.println("Line Segment 2: " + s2 + " to " + e2);
		System.out.println("Intersection: " + (intersection == null ? "None" : intersection));
		if (intersection != null) {
			System.out.println("Intersection is on segment1: " + Tester.checkIfPointOnLineSegments(s1, intersection, e1));
			System.out.println("Intersection is on segment1: " + Tester.checkIfPointOnLineSegments(s2, intersection, e2));
		}
	}
    
}

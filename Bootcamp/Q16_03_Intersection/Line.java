package Q16_03_Intersection;

public class Line {
    public Point start;
    public Point end;
    public double slope;
    public double yintercept;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        if (start.x == end.x){
            slope = Double.POSITIVE_INFINITY;
            yintercept = Double.POSITIVE_INFINITY;
        }else{
            slope = (end.y-start.y)/(end.x-start.x);
            yintercept =  end.y - slope * end.x;
        }
    }

    public boolean isVertical(){
        return slope == Double.POSITIVE_INFINITY;
    }

    public double getYFromX(double x){
        if(isVertical()){
            return Double.POSITIVE_INFINITY;
        }
        return slope * x + yintercept;
    }

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

    public boolean inLine(Point p){
        if(isVertical() && p.x == start.x){
            return true;
        }else{
            double newslope1 = (end.y-p.y)/(end.x-p.x);
            double newslope2 = (p.y-start.y)/(end.x-start.x);
            boolean inline = (p.y == slope * p.x + yintercept);
            return inline && (isBetween(start,p,end));
        }
    }


    @Override
    public String toString() {
        return "Line [end=" + end + ", slope=" + slope + ", start=" + start + ", yintercept=" + yintercept + "]";
    }

    
    
}

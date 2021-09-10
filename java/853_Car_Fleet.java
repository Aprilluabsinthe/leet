class Car{
    int leftDis;
    double time;
    Car(int p, double t){
        this.leftDis = p;
        this.time = t;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int nCars = position.length;
        Car[] cars = new Car[nCars];
        for(int i = 0 ; i < nCars ; i++){
            cars[i] = new Car( (target-position[i]) , (double)(target-position[i])/speed[i] );
        }
        Arrays.sort(cars, new Comparator<Car>(){
            @Override
            public int compare(Car c1, Car c2){
                return c1.leftDis-c2.leftDis;
            }
        } );


        int res = 0, t = 0;
        double slowest = 0.0;

        while (t < nCars) {
            if (cars[t].time > slowest){
                res++; //if cars[t] arrives sooner, it can't be caught
                slowest = cars[t].time;
            }
            t++;
        }

        return res; //lone car is fleet (if it exists)
    }
}
abstract class Bicycle {

    // Поля
    private String color;
    private String modelName;
    private int maxSpeed;

    public static int countBicycles;

    // 2 метода
    public void rotatePedals(){
        System.out.println("Катимся");
    }

    public void brake(){
        System.out.println("Тормозим");
    }

    // Геттеры
    public String getColor(){
        return this.color;
    }

    public String getModelName(){
        return this.modelName;
    }

    public int getMaxSpeed(){
        return this.maxSpeed;
    }

    // Сеттеры
    public void setColor(String clr){
        this.color = clr;
    }

    public void setModelName(String mn){
        this.modelName = mn;
    }

    public void setMaxSpeed(int ms){
        this.maxSpeed = ms;
    }

    // Конструкторы

    public Bicycle(String Color, String Model, int Speed){
        this.color = Color;
        this.modelName = Model;
        this.maxSpeed = Speed;

        Bicycle.countBicycles++;
    }

    public Bicycle(){
        this.color = "Green";
        this.modelName = "Stels";
        this.maxSpeed = 10;

        Bicycle.countBicycles++;
    }
}

class Mountain_Bike extends Bicycle {
    // Поля
    private int maxAcceleration;
    private int maxWeight;
    private int maxClutch;

    // 2 метода
    public void onLights(){
        System.out.println();
    }

    public void offLights(){
        System.out.println();
    }

    public void brake(){
        System.out.println("11111");
    }

    // Конструкторы
    public Mountain_Bike(int Accel, int Weight, int Clutch, String Color, String Model, int Speed) {
        super(Color, Model, Speed);
        this.maxAcceleration = Accel;
        this.maxWeight = Weight;
        this.maxClutch = Clutch;
    }

    public Mountain_Bike(){
        super();
        this.maxAcceleration = 5;
        this.maxWeight = 8;
        this.maxClutch = 10;
    }

    // Сеттеры
    public void setAcc(int acc){
        this.maxAcceleration = acc;
    }

    public void setWeight(int wight){
        this.maxWeight = wight;
    }

    public void setClutch(int clt){
        this.maxClutch = clt;
    }

    // Геттеры
    public int getAcc(){
        return this.maxAcceleration;
    }

    public int getWeight(){
        return this.maxWeight;
    }

    public int getClutch(){
        return this.maxClutch;
    }
}

class Kid_Bicycle extends Bicycle{
    // Поля
    private int addTire;
    private String bellSound;
    private boolean hasGPS;

    // 2 метода
    public void addTires(int tires){
        System.out.println("" + tires);
    }

    public void removeAddTires(int tires){
        System.out.println();
    }

    @Override
    public void rotatePedals(){
        System.out.println("Едем медленно");
    }

    // Конструкторы
    public Kid_Bicycle(int Tires, String Bell, boolean GPS, String Color, String Model, int Speed){
        super(Color, Model, Speed);
        this.addTire = Tires;
        this.bellSound = Bell;
        this.hasGPS = GPS;
    }

    public Kid_Bicycle(){
        super();
        this.addTire = 0;
        this.bellSound = "Колокольчик";
        this.hasGPS = false;
    }

    // Сеттеры
    public void setTires(int tire ){
        this.addTire = tire;
    }

    public void setSounds(String sound){
        this.bellSound = sound;
    }

    public void setGPS(boolean gps ){
        this.hasGPS = gps;
    }

    // Геттеры
    public  int getTires(){
        return this.addTire;
    }

    public String getSounds(){
        return this.bellSound;
    }

    public boolean getGPS(){
        return this.hasGPS;
    }
}

class BMX extends Bicycle{
    // Поля
    private String frameType;
    private String tiresType;
    private int modelVersion;

    // 2 метода
    public void stuntBarspin(){
        System.out.println();
    }

    public void stuntAir(){
        System.out.println();
    }

    @Override
    public void rotatePedals(){
        System.out.println("Speeding");
    }

    // Конструкторы
    public BMX(String Frame, String Tires, int modelV, String Color, String Model, int Speed){
        super(Color, Model, Speed);
        this.frameType = Frame;
        this.tiresType = Tires;
        this.modelVersion = modelV;
    }

    public BMX(){
        super();
        this.frameType = "";
        this.tiresType = "";
        this.modelVersion = 1;
    }

    // Геттеры
    public String getFrame(){
        return frameType;
    }

    public String getTireT(){
        return tiresType;
    }

    public int getModel(){
        return modelVersion;
    }

    // Сеттеры
    public void setFrame(String frame){
        this.frameType = frame;
    }

    public void setTire(String tireS){
        this.tiresType = tireS;
    }

    public void setModel(int version){
        this.modelVersion = version;
    }
}


public class Bicycles{
    public static void main(String[] args){
        BMX bic = new BMX();
        bic.rotatePedals();
        Kid_Bicycle kbic = new Kid_Bicycle();
        kbic.brake();
        Mountain_Bike Mbike = new Mountain_Bike(24, 30, 25, "Red", "Hren", 27 );
        Mbike.brake();
        System.out.println("Max speed for Mountain bike: " + Mbike.getMaxSpeed());
        System.out.println(Bicycle.countBicycles);
    }
}

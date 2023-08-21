public class VictorianFurnitureFactory implements FurnitureFactory {

  @Override
  public  Chair createChair() {
    return new VictorianChair();
  }

  @Override
  public  Sofa createSofa() {
    return new VictorianSofa();
  }

  public static void main(String[] args) {
    VictorianFurnitureFactory vFactory = new VictorianFurnitureFactory();
    Chair chair = vFactory.createChair();
  }
}

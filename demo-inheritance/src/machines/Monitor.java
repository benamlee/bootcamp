package machines;

import java.util.Objects;

public class Monitor {

  private double length;
  private double width;

  public Monitor(double length, double width) {
    this.length = length;
    this.width = width;
  }

  public double getLength() {
    return this.length;
  }

  public double getWidth() {
    return this.width;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Monitor))
      return false;
    Monitor monitor = (Monitor) o;
    return Objects.equals(monitor.length, this.length)
        && Objects.equals(monitor.width, this.width);
  }


}

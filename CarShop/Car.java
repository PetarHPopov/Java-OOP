package CarShop;

import java.io.Serializable;

public interface Car extends Serializable {
    public static final int TIRES = 4;

    public String getModel();
    public String getColor();
    public int getHorsePower();
    public String countryProduced();
}

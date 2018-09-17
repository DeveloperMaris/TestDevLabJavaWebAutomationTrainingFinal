package general;

import lombok.Data;

@Data
public class Flight {

    private String locationFrom;
    private String locationFromCode;
    private String locationTo;
    private String locationToCode;
    private String tripType;
    private String tripDataType;
    private String classType;
    private String departureDate;
    private String arrivalDate;
    private String adultCount;
    private String childCount;
    private String infantCount;
    private String flightPrice;

}

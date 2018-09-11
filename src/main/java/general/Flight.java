package general;

import lombok.Data;

@Data
public class Flight {

    private String locationFrom;
    private String locationTo;
    private String tripType;
    private String classType;
    private String departureDate;
    private String arrivalDate;
    private String adultCount;
    private String childCount;
    private String infantCount;

}

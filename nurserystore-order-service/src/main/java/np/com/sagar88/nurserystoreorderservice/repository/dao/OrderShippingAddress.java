package np.com.sagar88.nurserystoreorderservice.repository.dao;

import np.com.sagar88.nurserystoreorderservice.commons.util.DateAudit;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

/**
 * @author Sagar Subedi, Date : 07-Dec-2020
 */
@Entity
@Table(name = "ORDER_SHIPPING_ADDRESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderShippingAddress extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ORDER_SHIPPING_ID", updatable = false, nullable = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String orderShippingId;

    @Column(name = "ORDER_ID", updatable = false, nullable = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String orderId;

    @Column(name = "ADDRESS_LINE1", nullable = false)
    private String addressLine1;

    @Column(name = "ADDRESS_LINE2")
    private String addressLine2;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "POSTAL_CODE", nullable = false)
    private String postalCode;

    @Pattern(regexp = "[A-Z]{2}", message = "2-letter ISO country code required")
    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "PHONE")
    private String phone;
}

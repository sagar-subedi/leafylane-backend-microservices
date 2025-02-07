package np.com.sagar88.nurserystorebillingservice.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import np.com.sagar88.nurserystorebillingservice.commons.util.DateAudit;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

/**
 * @author: Sagar Subedi,
 * Date : 2019-09-20
 */
@Entity
@Table(name = "ADDRESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDao extends DateAudit {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ADDRESS_ID", updatable = false, nullable = false)
    private String addressId;
    
    @Column(name = "USER_ID", nullable = false)
    private String userId;
    
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
    @NonNull
    private String country;

    @Column(name = "PHONE")
    private String phone;
}

package com.research.purchasesales.entity;
import java.util.ArrayList;
import java.util.Date;

import com.research.garage.entity.GarageProjection;
import com.research.garage.entity.OrganisationProjection;
import com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator;
import java.util.List;

//github.com/ikyamResearch2/Research.git

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity(name = "Purchase")
@Table(name = "Purchase")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseProjection  {
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "demo_sql")
	@GenericGenerator(name = "demo_sql",strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator",parameters = {
			
			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM,value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER,value = "PUR_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER,value = "%05d"),
			
			
			
	} )
	@Id
	@Column(unique=true, length = 50)
	private String PurcahseID;
	 @Column(length = 100)
	    private String Entry_Type;
	 @Column(length = 100)
	    private String OrganisationID;
//	 @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//		@JoinColumn(name="orgId")
//	    private OrganisationProjection organisation;
//	 @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//		@JoinColumn(name="GarageID")
//		private GarageProjection garage;
	
	  @CreatedDate
	private Date Entry_Date;
    @Column(length = 100)
    private String VendorID;
    @Column(length = 50)
    private String Supplierrefno;
    @Column(length = 50)
    private Date Supplierref_Posting_Date;
    @Column(length = 50)
    private String Jobno;
    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE}, mappedBy = "Purchase") 
    @ToString.Exclude
	private List<PurchaseLineProjection> Purchaseline;
    
    
	public void add(PurchaseLineProjection theItems) {
		if(Purchaseline==null) {
			Purchaseline= new ArrayList<PurchaseLineProjection>();
		}
		Purchaseline.add(theItems);
		theItems.setPurchase(this);
	}

	

}
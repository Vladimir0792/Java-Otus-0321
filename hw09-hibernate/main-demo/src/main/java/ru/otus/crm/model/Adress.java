package ru.otus.crm.model;

import javax.persistence.*;

@Entity
@Table(name = "address", schema = "model")

class AddressDataSet {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "address_sequencer", schema = "model")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequencer")
    private Long id;

    @Column(name="street")
    private String street;

    @OneToOne(mappedBy = "address")
    private Client client;

    public AddressDataSet(Long id, String street){
        this.id = id;
        this.street = street;
    }

    @Override
    public AddressDataSet clone(){
        return new AddressDataSet(this.id,this.street);
    }
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", street='" + street + '\'' +
                '}';
    }


}

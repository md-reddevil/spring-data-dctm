## Spring Data for Documentum 
Spring data helps a developer remove all the boiler plate code to access a Data repository. 
Spring Data for Documentum allows Documentum developers to access Documentum Repository with minimum code. All developers have to write is Domain Class like Person.java or Contact.java and one interface. Spring Data for Documentum takes care of all the CRUD operation for the developer. 

A Spring Data for Documentum Sample can be found [here](https://github.com/waliaraman/spring-data-sample).  

## Getting Started

Add Spring Data for Documentum to your pom.xml and youa re ready to go. 
````
        <dependency>
            <groupId>com.emc.documentum.spring</groupId>
            <artifactId>spring-boot-starter-dctm</artifactId>
            <version>0.0.1</version>
        </dependency>
````

This would ensure that you have all the dependencies needed to get started. As will all Spring Data projects, now all you need is create you domain objects 

````
@DctmEntity(repository = "contact")
@Entity(name="contact")
public class Contact {

	@Id
	protected String id;

	@DctmAttribute(value="object_name")
	private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

````


and expose them using DCTM Repository 

````
public interface ContactRepository extends DctmRepositoryWithContent<Contact, String> {

    public Iterable<Contact> findAll();


    public Iterable<Contact> findByNameContaining(String value);
}

````

This would get you all the CRUD operations for Documentum Repository. 

If the same domain objects is needed to be exposed as a Rest Service, just include the Spring Data Rest dependency in your pom.xml

````


        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-rest</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-rest-webmvc</artifactId>
        </dependency>
        
````

Spring Data for Rest also hooks into Spring Security, so the Authentication would be done against the content server. 



## Built With

* Maven


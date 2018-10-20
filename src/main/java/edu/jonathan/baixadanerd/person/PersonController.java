package edu.jonathan.baixadanerd.person;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/persons")
public class PersonController {

    @Inject
    private PersonService personService;

    @GET
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @GET
    @Path("/{id}")
    public Person getPersonBy(@PathParam("id") Long id){
        return personService.getPersonBy(id);
    }

    @POST
    public Person insertPerson(Person person){
        return personService.insertPerson(person);
    }


}

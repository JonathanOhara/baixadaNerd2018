package edu.jonathan.baixadanerd.person;

import name.falgout.jeffrey.testing.junit.mockito.MockitoExtension;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Arrays;

@ExtendWith({MockitoExtension.class})
@RunWith(JUnitPlatform.class)
public class PersonServiceTest {

    @InjectMocks
    PersonService service;

    @Mock
    EntityManager entityManager;

    @Test
    public void shouldGetPersons(){
        TypedQuery query = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.createQuery("SELECT p FROM Person p", Person.class)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(Arrays.asList(new Person()));

        Assert.assertEquals(1, service.getPersons().size());
    }
}

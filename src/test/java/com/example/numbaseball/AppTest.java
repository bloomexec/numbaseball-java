package com.example.numbaseball;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private App app;

    @Before
    public void init() {
        app = new App();
    }
    
    @Test
    public void instanceCreationTest() {
        assertNotNull(app);
    }

}

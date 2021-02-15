package com.stackroute.lamdbaexpression;

import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConsumerFunctionalInterfaceTests {
    private ConsumerFunctionalInterface consumerFunctionalInterface;

    private static final String MESSAGE = "Check the logic of your method findPattern";

    @BeforeEach
    public void setUp() {
        consumerFunctionalInterface = new ConsumerFunctionalInterface();
    }

    @AfterEach
    public void tearDown() {
        consumerFunctionalInterface = null;
    }

    @Test
    public void givenListThenReturnResult() {
        List<BigInteger> inputList = new ArrayList<>();
        inputList.add(new BigInteger("20"));
        inputList.add(new BigInteger("3"));
        inputList.add(new BigInteger("30"));
        List<BigInteger> output = new ArrayList<>();
        output.add(new BigInteger("400"));
        output.add(new BigInteger("9"));
        output.add(new BigInteger("900"));
        assertEquals(output, consumerFunctionalInterface.findSquare(inputList), MESSAGE);
    }

    @Test
    public void givenListWithLargeNumbersThenReturnResult() {
        List<BigInteger> inputList = new ArrayList<>();
        inputList.add(new BigInteger("1201232093278943274931574305483758437584327582"));
        inputList.add(new BigInteger("424242121832486182468924384683726587438568234587436586"));
        inputList.add(new BigInteger("32786481263914348798325893148561893465786348658326"));
        List<BigInteger> output = new ArrayList<>();
        output.add(new BigInteger("1442958541923311877026468220152104901331325522094319111418200854121990784870057391085966724"));
        output.add(new BigInteger("179981377936930049200652239095371428802060017257456566857216210154661788052734884438564772563099990571335396"));
        output.add(new BigInteger("1074953353669006634658152956691129195845046715477152364297701792770564267670764138691631100289122276"));
        assertEquals(output, consumerFunctionalInterface.findSquare(inputList), MESSAGE);
    }

    @Test
    public void givenListWithNegativeNumbersThenReturnResult() {
        List<BigInteger> inputList = new ArrayList<>();
        inputList.add(new BigInteger("-3432874638764367235474523745"));
        inputList.add(new BigInteger("-23163416534621365421631"));
        inputList.add(new BigInteger("-9993828384238094299999"));
        List<BigInteger> output = new ArrayList<>();
        output.add(new BigInteger("11784628285471584838141590189345524651040162934568825025"));
        output.add(new BigInteger("536543865556370465318512868281106670402700161"));
        output.add(new BigInteger("99876605773602998602853923638924013811400001"));
        assertEquals(output, consumerFunctionalInterface.findSquare(inputList), MESSAGE);
    }

    @Test
    public void givenEmptyListThenReturnResult() {
        List<BigInteger> inputList = new ArrayList<>();
        List<BigInteger> output = new ArrayList<>();
        assertEquals(output, consumerFunctionalInterface.findSquare(inputList), MESSAGE);
    }

    @Test
    public void givenListWithZeroThenReturnResult() {
        List<BigInteger> inputList = new ArrayList<>();
        inputList.add(new BigInteger("0"));
        inputList.add(new BigInteger("000000000000000"));
        inputList.add(new BigInteger("00000000000000000000000000000000000000"));
        List<BigInteger> output = new ArrayList<>();
        output.add(new BigInteger("0"));
        output.add(new BigInteger("0"));
        output.add(new BigInteger("0"));
        assertEquals(output, consumerFunctionalInterface.findSquare(inputList), MESSAGE);
    }

    @Test
    public void givenListThenShouldNotReturnNull() {
        List<BigInteger> inputList = new ArrayList<>();
        inputList.add(new BigInteger("73264736874723823656487236486238764873264872638764832648736"));
        inputList.add(new BigInteger("832847382789324937472371647"));
        assertNotNull(consumerFunctionalInterface.findSquare(inputList), MESSAGE);
    }
}

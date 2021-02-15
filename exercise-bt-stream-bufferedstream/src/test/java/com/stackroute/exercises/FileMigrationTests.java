package com.stackroute.exercises;

import org.junit.jupiter.api.*;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileMigrationTests {

    private FileMigration fileMigration;
    private String firstFile = "test.txt";
    private String secondFile = "testBackup.txt";
    private String message = "Check the logic in method fileContentDuplicator";
    private String expectedErrorMessage = "Given fileName to read or write is empty, null or blank space";

    @BeforeEach
    public void setUp() {
        fileMigration = new FileMigration();
    }

    @AfterEach
    public void tearDown() {
        fileMigration = null;
    }

    @Test
    public void givenTwoFileNameStringsThenReturnAStringResult() throws IOException {
        assertEquals(fileMigration.fileContentDuplicator(firstFile, secondFile), new String(new FileInputStream(secondFile).readAllBytes()), "Check the Logic in method fileContentDuplicator");
        assertEquals(fileMigration.fileContentDuplicator("testBackup.txt ", " newTest.txt"), new String(new FileInputStream("newTest.txt").readAllBytes()), "The method fileContentDuplicator should remove unwanted space");
    }

    @Test
    public void givenWrongFileNameThenReturnAnException() {
        assertThrows(IOException.class, () -> fileMigration.fileContentDuplicator("test", " testBackup.txt"));
        assertThrows(IOException.class, () -> fileMigration.fileContentDuplicator("testing.txt", "testBackup.txt "));
    }

    @Test
    public void givenEmptyFileNameStringThenReturnAnErrorString() throws IOException {
        assertEquals(expectedErrorMessage, fileMigration.fileContentDuplicator(firstFile, ""), message);
        assertEquals(expectedErrorMessage, fileMigration.fileContentDuplicator("", secondFile), message);
        assertEquals(expectedErrorMessage, fileMigration.fileContentDuplicator("", ""), message);
    }

    @Test
    public void givenBlankSpaceFileNameThenReturnAnErrorString() throws IOException {
        assertEquals(expectedErrorMessage, fileMigration.fileContentDuplicator(firstFile, " "), message);
        assertEquals(expectedErrorMessage, fileMigration.fileContentDuplicator(" ", secondFile), message);
        assertEquals(expectedErrorMessage, fileMigration.fileContentDuplicator(" ", " "), message);
    }

    @Test
    public void givenNullFileNameThenReturnAnErrorString() throws IOException {
        assertEquals(expectedErrorMessage, fileMigration.fileContentDuplicator(firstFile, null), message);
        assertEquals(expectedErrorMessage, fileMigration.fileContentDuplicator(null, secondFile), message);
        assertEquals(expectedErrorMessage, fileMigration.fileContentDuplicator(null, null), message);
    }

}

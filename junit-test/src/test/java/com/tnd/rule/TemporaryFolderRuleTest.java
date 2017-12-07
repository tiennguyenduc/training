package com.tnd.rule;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TemporaryFolderRuleTest {

    /** create temporary file/folder and delete when test finishes **/
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testUsingTempFolder() throws IOException {
        File createdFile = folder.newFile("myfile.txt");
        File createdFolder = folder.newFolder("mysubfolder");
    }
    /** -- END -- **/

}

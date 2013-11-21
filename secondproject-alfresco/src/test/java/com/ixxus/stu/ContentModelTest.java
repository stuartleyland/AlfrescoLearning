package com.ixxus.stu;

import org.junit.Test;

import com.ixxus.test.AlfrescoTestUtils;

public class ContentModelTest {

    @Test
    public void testBootstrapModel() throws Exception {
        AlfrescoTestUtils.testBootstrapModel("alfresco/module/secondproject/model/content-model.xml");
    }
}
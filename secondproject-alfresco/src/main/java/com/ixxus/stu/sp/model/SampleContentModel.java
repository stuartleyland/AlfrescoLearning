package com.ixxus.stu.sp.model;

import org.alfresco.service.namespace.QName;

/**
 * 
 * TODO: Change the name to something other than SampleContentModel
 *
 */
public class SampleContentModel {
    public final static String NAMESPACE_URI = "http://www.ixxus.co.uk/model/secondproject/1.0";
    public final static String NAMESPACE_PREFIX = "sp";

    public static final class SampleAspect {
        public static final QName ASPECT = sp("sampleAspect");

        private SampleAspect() {
        }

        public static final class Prop {
            private Prop() {
            }
            
            public static final QName SAMPLE_ASPECT_PROPERTY = sp("sampleAspectProperty");
        }
    }

    public static final class SampleType {
    	public static final QName TYPE = sp("sampleType");

    	private SampleType() {
    	}

    	public static final class Prop {
            private Prop() {
            }
            
            public static final QName SAMPLE_TYPE_PROPERTY = sp("sampleTypeProperty");
        }
    }
    
    public static QName sp(final String qname) {
        return QName.createQName(NAMESPACE_URI, qname);
    }
}
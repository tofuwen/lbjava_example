// Modifying this comment will cause the next execution of LBJava to overwrite this file.
// F1B88000000000000000B49CC2E4E2A4D294DA65A2E284CC552D1505AC00255BA01C04E9F42625A6E868B4E72796E6A6E59824A86A28D8EA245B2005979615E924A8E5A7A69044986A5B24D20037E1511994000000

package edu.illinois.cs.cogcomp.tutorial;

import edu.illinois.cs.cogcomp.lbjava.classify.*;
import edu.illinois.cs.cogcomp.lbjava.infer.*;
import edu.illinois.cs.cogcomp.lbjava.io.IOUtilities;
import edu.illinois.cs.cogcomp.lbjava.learn.*;
import edu.illinois.cs.cogcomp.lbjava.parse.*;
import java.util.List;


public class SpamLabel extends Classifier
{
  public SpamLabel()
  {
    containingPackage = "edu.illinois.cs.cogcomp.tutorial";
    name = "SpamLabel";
  }

  public String getInputType() { return "edu.illinois.cs.cogcomp.tutorial.Document"; }
  public String getOutputType() { return "discrete"; }

  private static String[] __allowableValues = new String[]{ "spam", "ham" };
  public static String[] getAllowableValues() { return __allowableValues; }
  public String[] allowableValues() { return __allowableValues; }


  public FeatureVector classify(Object __example)
  {
    return new FeatureVector(featureValue(__example));
  }

  public Feature featureValue(Object __example)
  {
    String result = discreteValue(__example);
    return new DiscretePrimitiveStringFeature(containingPackage, name, "", result, valueIndexOf(result), (short) allowableValues().length);
  }

  public String discreteValue(Object __example)
  {
    if (!(__example instanceof Document))
    {
      String type = __example == null ? "null" : __example.getClass().getName();
      System.err.println("Classifier 'SpamLabel(Document)' defined on line 18 of SpamClassifier.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    String __cachedValue = _discreteValue(__example);

    if (valueIndexOf(__cachedValue) == -1)
    {
      System.err.println("Classifier 'SpamLabel' defined on line 18 of SpamClassifier.lbj produced '" + __cachedValue  + "' as a feature value, which is not allowable.");
      System.exit(1);
    }

    return __cachedValue;
  }

  private String _discreteValue(Object __example)
  {
    Document d = (Document) __example;

    return "" + (d.getLabel());
  }

  public FeatureVector[] classify(Object[] examples)
  {
    if (!(examples instanceof Document[]))
    {
      String type = examples == null ? "null" : examples.getClass().getName();
      System.err.println("Classifier 'SpamLabel(Document)' defined on line 18 of SpamClassifier.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    return super.classify(examples);
  }

  public int hashCode() { return "SpamLabel".hashCode(); }
  public boolean equals(Object o) { return o instanceof SpamLabel; }
}


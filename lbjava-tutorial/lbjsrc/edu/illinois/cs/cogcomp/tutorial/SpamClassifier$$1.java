// Modifying this comment will cause the next execution of LBJava to overwrite this file.
// F1B88000000000000000B49CC2E4E2A4D294555580E284CC57EC94C2E2ECC4BCC4D22515134D079CF4E2DCD4DCB215841D450B1D5580FCF2A417B4D4C292D2A4D26D1507ACC4F2A4CC540F10C4890B4794000000

package edu.illinois.cs.cogcomp.tutorial;

import edu.illinois.cs.cogcomp.lbjava.classify.*;
import edu.illinois.cs.cogcomp.lbjava.infer.*;
import edu.illinois.cs.cogcomp.lbjava.io.IOUtilities;
import edu.illinois.cs.cogcomp.lbjava.learn.*;
import edu.illinois.cs.cogcomp.lbjava.parse.*;
import java.util.List;


public class SpamClassifier$$1 extends Classifier
{
  private static final WordFeatures __WordFeatures = new WordFeatures();
  private static final BigramFeatures __BigramFeatures = new BigramFeatures();

  public SpamClassifier$$1()
  {
    containingPackage = "edu.illinois.cs.cogcomp.tutorial";
    name = "SpamClassifier$$1";
  }

  public String getInputType() { return "edu.illinois.cs.cogcomp.tutorial.Document"; }
  public String getOutputType() { return "discrete%"; }

  public FeatureVector classify(Object __example)
  {
    if (!(__example instanceof Document))
    {
      String type = __example == null ? "null" : __example.getClass().getName();
      System.err.println("Classifier 'SpamClassifier$$1(Document)' defined on line 23 of SpamClassifier.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    FeatureVector __result;
    __result = new FeatureVector();
    __result.addFeatures(__WordFeatures.classify(__example));
    __result.addFeatures(__BigramFeatures.classify(__example));
    return __result;
  }

  public FeatureVector[] classify(Object[] examples)
  {
    if (!(examples instanceof Document[]))
    {
      String type = examples == null ? "null" : examples.getClass().getName();
      System.err.println("Classifier 'SpamClassifier$$1(Document)' defined on line 23 of SpamClassifier.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    return super.classify(examples);
  }

  public int hashCode() { return "SpamClassifier$$1".hashCode(); }
  public boolean equals(Object o) { return o instanceof SpamClassifier$$1; }

  public java.util.LinkedList getCompositeChildren()
  {
    java.util.LinkedList result = new java.util.LinkedList();
    result.add(__WordFeatures);
    result.add(__BigramFeatures);
    return result;
  }
}


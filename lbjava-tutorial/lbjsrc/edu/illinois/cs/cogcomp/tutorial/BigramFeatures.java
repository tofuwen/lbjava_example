// Modifying this comment will cause the next execution of LBJava to overwrite this file.
// F1B88000000000000000D4C81BA02C040144F756808077C1906A5F26322656F6D127B68D22938DDB34052FFEEA8616333CCB91621BE4245867831FC23E271A1B4512577EC35D586D284E134B871EACA50F8C2941744AE66A27BF407E32EE950E8D6BC65DE3A9D0FD567ACF427E1D2A73A1287BF15A559E75BD9836F8086AD6C4FF0A5AED3E0822592263C6F63CB4CED09A000000

package edu.illinois.cs.cogcomp.tutorial;

import edu.illinois.cs.cogcomp.lbjava.classify.*;
import edu.illinois.cs.cogcomp.lbjava.infer.*;
import edu.illinois.cs.cogcomp.lbjava.io.IOUtilities;
import edu.illinois.cs.cogcomp.lbjava.learn.*;
import edu.illinois.cs.cogcomp.lbjava.parse.*;
import java.util.List;


public class BigramFeatures extends Classifier
{
  public BigramFeatures()
  {
    containingPackage = "edu.illinois.cs.cogcomp.tutorial";
    name = "BigramFeatures";
  }

  public String getInputType() { return "edu.illinois.cs.cogcomp.tutorial.Document"; }
  public String getOutputType() { return "discrete%"; }

  public FeatureVector classify(Object __example)
  {
    if (!(__example instanceof Document))
    {
      String type = __example == null ? "null" : __example.getClass().getName();
      System.err.println("Classifier 'BigramFeatures(Document)' defined on line 13 of SpamClassifier.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    Document d = (Document) __example;

    FeatureVector __result;
    __result = new FeatureVector();
    String __id;
    String __value;

    List words = d.getWords();
    for (int i = 0; i < words.size() - 1; i++)
    {
      __id = "" + (words.get(i) + "-" + words.get(i + 1));
      __value = "true";
      __result.addFeature(new DiscretePrimitiveStringFeature(this.containingPackage, this.name, __id, __value, valueIndexOf(__value), (short) 0));
    }
    return __result;
  }

  public FeatureVector[] classify(Object[] examples)
  {
    if (!(examples instanceof Document[]))
    {
      String type = examples == null ? "null" : examples.getClass().getName();
      System.err.println("Classifier 'BigramFeatures(Document)' defined on line 13 of SpamClassifier.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    return super.classify(examples);
  }

  public int hashCode() { return "BigramFeatures".hashCode(); }
  public boolean equals(Object o) { return o instanceof BigramFeatures; }
}


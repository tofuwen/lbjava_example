// Modifying this comment will cause the next execution of LBJava to overwrite this file.
// F1B88000000000000000D2CC1BA02C0401481E7599648B3281CADB8D9859DB5B4E649D2CC1CDEE12424EDDDD06AA92EFF89C2A365A1F08749A9F6C7A5BA4D07D236BF07234E881E885077153C7D982E28CDFB96B97D0131E55A2288B51F47A4E33CF56FA2337312D571DF3493927F4E701422EC0BAD890B26DF14A119247A8000000

package edu.illinois.cs.cogcomp.tutorial;

import edu.illinois.cs.cogcomp.lbjava.classify.*;
import edu.illinois.cs.cogcomp.lbjava.infer.*;
import edu.illinois.cs.cogcomp.lbjava.io.IOUtilities;
import edu.illinois.cs.cogcomp.lbjava.learn.*;
import edu.illinois.cs.cogcomp.lbjava.parse.*;
import java.util.List;


/** Simply produces "bag of words" features. */
public class WordFeatures extends Classifier
{
  public WordFeatures()
  {
    containingPackage = "edu.illinois.cs.cogcomp.tutorial";
    name = "WordFeatures";
  }

  public String getInputType() { return "edu.illinois.cs.cogcomp.tutorial.Document"; }
  public String getOutputType() { return "discrete%"; }

  public FeatureVector classify(Object __example)
  {
    if (!(__example instanceof Document))
    {
      String type = __example == null ? "null" : __example.getClass().getName();
      System.err.println("Classifier 'WordFeatures(Document)' defined on line 7 of SpamClassifier.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    Document d = (Document) __example;

    FeatureVector __result;
    __result = new FeatureVector();
    String __id;
    String __value;

    List words = d.getWords();
    for (int i = 0; i < words.size(); i++)
    {
      __id = "" + (words.get(i));
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
      System.err.println("Classifier 'WordFeatures(Document)' defined on line 7 of SpamClassifier.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    return super.classify(examples);
  }

  public int hashCode() { return "WordFeatures".hashCode(); }
  public boolean equals(Object o) { return o instanceof WordFeatures; }
}


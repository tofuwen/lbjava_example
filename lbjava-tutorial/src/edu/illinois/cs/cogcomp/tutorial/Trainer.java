package edu.illinois.cs.cogcomp.tutorial;

import edu.illinois.cs.cogcomp.lbjava.classify.TestDiscrete;
import edu.illinois.cs.cogcomp.lbjava.learn.BatchTrainer;
import edu.illinois.cs.cogcomp.lbjava.parse.Parser;

/**
 * Created by christos on 1/12/15.
 */
public class Trainer {
    SpamClassifier classifier;
    String trainFolder, testFolder, modelDir;

    public Trainer(String trainFolder, String testFolder) {
        this.trainFolder = trainFolder;
        this.testFolder = testFolder;
        // We need to place thin inside the compilation directory in order to accessible through the classpath
        this.modelDir = "bin/edu/illinois/cs/cogcomp/tutorial/";
        String modelPath = modelDir + "SpamClassifier.lc";
        String lexiconPath = modelDir + "SpamClassifier.lex";
        classifier = new SpamClassifier(modelPath, lexiconPath);
        // In case the model/lexicon files already exist
        classifier.forget();
    }

    /**
     * Performs the training of the classifier
     * @param numRounds The number of training iterations (change this to -1 to train until convergence)
     */
    public void train(int numRounds) {
        // Temporary files that can be deleted
        String trainExampleFilePath = modelDir + "SpamClassifier.ex";
        String testExampleFilePath = modelDir + "SpamClassifier.test.ex";

        // Give an update every 2000 documents
        int outEvery = 2000;

        BatchTrainer batchTrainer = new BatchTrainer(classifier, new DocumentReader(trainFolder), outEvery);
        classifier.setLexicon(batchTrainer.preExtract(trainExampleFilePath));

        BatchTrainer batchTester = new BatchTrainer(classifier, new DocumentReader(testFolder), outEvery, "test set: ");
        classifier.setLexicon(batchTester.preExtract(testExampleFilePath));

        batchTrainer.train(numRounds);
        classifier.save();

        System.out.println("Testing SpamClassifier, final performance: ");
        //overall precision, overall recall, F1, and accuracy.
        TestDiscrete simpleTest = new TestDiscrete();

        Parser testParser = batchTester.getParser();
        TestDiscrete.testDiscrete(simpleTest, classifier, null, testParser, true, 0);
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("usage: $>Trainer <train-folder> <test-folder> <training rounds>");
            System.exit(-1);
        }
        Trainer trainer = new Trainer(args[0], args[1]);
        trainer.train(Integer.parseInt(args[2]));
    }
}

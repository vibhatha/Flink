package edu.indiana.ise.examples

import org.apache.flink.api.scala._
import org.apache.flink.ml.RichExecutionEnvironment
import org.apache.flink.ml.classification.SVM
import org.apache.flink.ml.common.LabeledVector
import org.apache.flink.ml.math.Vector


object DemoSVM{

	def main(args: Array[String]){

		println("SVM Training Started...")

		val pathToTrainingFile: String = "/home/vibhatha/ds/data/ijcnn1.train";
		val pathToTestingFile: String = "/home/vibhatha/ds/data/ijcnn1.t";
		val env = ExecutionEnvironment.getExecutionEnvironment

		// Read the training data set, from a LibSVM formatted file
		val trainingDS: DataSet[LabeledVector] = env.readLibSVM(pathToTrainingFile)

		// Create the SVM learner
		val svm = SVM()
		  .setBlocks(1)

		// Learn the SVM model
		val train_start = System.nanoTime()
		svm.fit(trainingDS)
		val train_end = System.nanoTime()
		val train_eta = train_end - train_start
		println("Training Elapsed Time : "+ (train_eta/1000000) + " ms")

		println("SVM Training Completed...")

		// Read the testing data set
		val testingDS: DataSet[Vector] = env.readLibSVM(pathToTestingFile).map(_.vector)

		println("SVM Testing Started...")
		// Calculate the predictions for the testing data set
		val test_start = System.nanoTime()
		val predictionDS: DataSet[(Vector, Double)] = svm.predict(testingDS)
		val predcount = predictionDS.count();
		println("Prediction Count : " +predcount)
		val test_end = System.nanoTime()
		val test_eta = test_end - test_start
		println("Testing Elapsed Time : "+ (test_eta/1000000) + " ms")

		println("SVM Testing Completed...")



	}

}

package ada.ensembles


import ada._
import ada.interface._
import ada.components.selectors._
import ada.components.distributions._
import breeze.stats.distributions.Beta

class ContextualThompsonSampling
    [ModelID, ModelData, ModelAction]
    (models: ModelID  => ContextualModel[ModelID, Array[Double], ModelData, ModelAction],
     modelKeys: () => List[ModelID],
     modelRewards: Map[ModelID, BayesianSampleRegressionDistribution])
    extends ContextualGreedy[ModelID, Array[Double], ModelData, ModelAction, BayesianSampleRegressionDistribution](
        models,
        modelKeys,
        modelRewards,
        0.0
    )

object ContextualThompsonSampling{
    def apply[ModelID, ModelData, ModelAction](
        models: Map[ModelID, ContextualModel[ModelID, Array[Double], ModelData, ModelAction]],
        modelRewards: Map[ModelID, BayesianSampleRegressionDistribution]) = {
            new ContextualThompsonSampling[ModelID, ModelData, ModelAction](
                key => models(key),
                () => models.keys.toList,
                modelRewards
            )
        }

}
    

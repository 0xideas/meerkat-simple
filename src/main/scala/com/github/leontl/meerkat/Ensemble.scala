package com.github.leontl.meerkat

import ada.ensembles.ThompsonSamplingEnsemble
import ada.models.GenericStaticModel
import io.circe.Json
import ada.components.distributions.BetaDistribution
import org.apache.commons.math3.distribution.{BetaDistribution => Beta}
import ada.`package`.Reward

object Ensemble{
    val models = List( new GenericStaticModel[Int, Unit, String, Beta]("a")(s => Json.fromString(s)),
        new GenericStaticModel[Int, Unit, String, Beta]("b")(s => Json.fromString(s)))

    val ensemble = ThompsonSamplingEnsemble[Int, Unit, String](
        models.zipWithIndex.map{case(k,v) => (v,k)}.toMap,
        1.0, 1.0)
    
    case class Update(val modelId:Int, val reward:Reward)

}

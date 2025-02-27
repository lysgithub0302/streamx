/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.streampark.spark.core

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

import scala.annotation.meta.getter

/**
 * <b><code>SparkBatch</code></b>
 * <p/>
 * Spark batch processing entry
 * <p/>
 * <b>Creation Time:</b> 2022/8/8 20:44.
 *
 * @author guoning
 * @since streampark
 */
trait SparkBatch extends Spark {

  @(transient@getter)
  protected lazy val context: SparkContext = sparkSession.sparkContext

  override def destroy(): Unit = {
    context.stop()
  }
}

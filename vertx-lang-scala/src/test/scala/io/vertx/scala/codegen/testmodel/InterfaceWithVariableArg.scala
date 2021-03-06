/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.codegen.testmodel

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.codegen.testmodel.{InterfaceWithVariableArg => JInterfaceWithVariableArg}
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}

/**
  */
class InterfaceWithVariableArg[T: TypeTag, U: TypeTag](private val _asJava: Object)
    extends GenericRefedInterface[U](_asJava)   {



  override def setValue(value: U): GenericRefedInterface[U] = {
    asJava.asInstanceOf[JInterfaceWithVariableArg[Object, Object]].setValue(toJava[U](value))
    this
  }

  override def getValue(): U = {
    toScala[U](asJava.asInstanceOf[JInterfaceWithVariableArg[Object, Object]].getValue())
  }

  def setOtherValue(value: T): Unit = {
    asJava.asInstanceOf[JInterfaceWithVariableArg[Object, Object]].setOtherValue(toJava[T](value))
  }

  def getOtherValue(): T = {
    toScala[T](asJava.asInstanceOf[JInterfaceWithVariableArg[Object, Object]].getOtherValue())
  }

}

object InterfaceWithVariableArg {
  def apply[T: TypeTag, U: TypeTag](asJava: JInterfaceWithVariableArg[_, _]) = new InterfaceWithVariableArg[T, U](asJava)  
}

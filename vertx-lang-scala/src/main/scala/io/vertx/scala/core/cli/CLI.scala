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

package io.vertx.scala.core.cli

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.cli.{Argument => JArgument}
import io.vertx.core.cli.{Option => JOption}
import io.vertx.core.cli.{CLI => JCLI}
import io.vertx.core.cli.{CommandLine => JCommandLine}
import scala.collection.JavaConverters._

/**
  * Interface defining a command-line interface (in other words a command such as 'run', 'ls'...).
  * This interface is polyglot to ease reuse such as in Vert.x Shell.
  * <p/>
  * A command line interface has a name, and defines a set of options and arguments. Options are key-value pair such
  * as `-foo=bar` or `-flag`. The supported formats depend on the used parser. Arguments are unlike
  * options raw values. Options are defined using
  * <a href="../../../../../../../cheatsheet/Option.html">Option</a>, while argument are defined using <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>.
  * <p/>
  * Command line interfaces also define a summary and a description. These attributes are used in the usage generation
  * . To disable the help generation, set the `hidden` attribute to `true`.
  * <p/>
  * Command Line Interface object does not contains "value", it's a model. It must be evaluated by a
  * parser that returns a [[io.vertx.scala.core.cli.CommandLine]] object containing the argument and option values.
  */
class CLI(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Sets the name of the CLI.
    * @param name the name
    * @return the current CLI instance
    */
  def setName(name: String):CLI = {
    asJava.asInstanceOf[JCLI].setName(name.asInstanceOf[java.lang.String])
    this
  }

  def setDescription(desc: String):CLI = {
    asJava.asInstanceOf[JCLI].setDescription(desc.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Sets the summary of the CLI.
    * @param summary the summary
    * @return the current CLI instance
    */
  def setSummary(summary: String):CLI = {
    asJava.asInstanceOf[JCLI].setSummary(summary.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Sets whether or not the current instance of [[io.vertx.scala.core.cli.CLI]] must be hidden. Hidden CLI are not listed when
    * displaying usages / help messages. In other words, hidden commands are for power user.
    * @param hidden enables or disables the hidden aspect of the CI
    * @return the current CLI instance
    */
  def setHidden(hidden: Boolean):CLI = {
    asJava.asInstanceOf[JCLI].setHidden(hidden.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Adds an option.
    * @param option the option, must not be `null`.see <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return the current CLI instance
    */
  def addOption(option: Option):CLI = {
    asJava.asInstanceOf[JCLI].addOption(option.asJava)
    this
  }

  /**
    * Adds a set of options. Unlike [[io.vertx.scala.core.cli.CLI#setOptions]]`, this method does not remove the existing options.
    * The given list is appended to the existing list.
    * @param options the options, must not be `null`
    * @return the current CLI instance
    */
  def addOptions(options: scala.collection.mutable.Buffer[Option]):CLI = {
    asJava.asInstanceOf[JCLI].addOptions(options.map(x => x.asJava).asJava)
    this
  }

  /**
    * Sets the list of arguments.
    * @param options the list of options, must not be `null`
    * @return the current CLI instance
    */
  def setOptions(options: scala.collection.mutable.Buffer[Option]):CLI = {
    asJava.asInstanceOf[JCLI].setOptions(options.map(x => x.asJava).asJava)
    this
  }

  /**
    * Adds an argument.
    * @param arg the argument, must not be `null`see <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    * @return the current CLI instance
    */
  def addArgument(arg: Argument):CLI = {
    asJava.asInstanceOf[JCLI].addArgument(arg.asJava)
    this
  }

  /**
    * Adds a set of arguments. Unlike [[io.vertx.scala.core.cli.CLI#setArguments]], this method does not remove the existing arguments.
    * The given list is appended to the existing list.
    * @param args the arguments, must not be `null`
    * @return the current CLI instance
    */
  def addArguments(args: scala.collection.mutable.Buffer[Argument]):CLI = {
    asJava.asInstanceOf[JCLI].addArguments(args.map(x => x.asJava).asJava)
    this
  }

  /**
    * Sets the list of arguments.
    * @param args the list of arguments, must not be `null`
    * @return the current CLI instance
    */
  def setArguments(args: scala.collection.mutable.Buffer[Argument]):CLI = {
    asJava.asInstanceOf[JCLI].setArguments(args.map(x => x.asJava).asJava)
    this
  }

  /**
    * Removes an option identified by its name. This method does nothing if the option cannot be found.
    * @param name the option name
    * @return the current CLI instance
    */
  def removeOption(name: String):CLI = {
    asJava.asInstanceOf[JCLI].removeOption(name.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Removes an argument identified by its index. This method does nothing if the argument cannot be found.
    * @param index the argument index
    * @return the current CLI instance
    */
  def removeArgument(index: Int):CLI = {
    asJava.asInstanceOf[JCLI].removeArgument(index.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Parses the user command line interface and create a new [[io.vertx.scala.core.cli.CommandLine]] containing extracting values.
    * @param arguments the arguments
    * @return the creates command line
    */
  def parse(arguments: scala.collection.mutable.Buffer[String]):CommandLine = {
    CommandLine(asJava.asInstanceOf[JCLI].parse(arguments.map(x => x.asInstanceOf[java.lang.String]).asJava))
  }

  /**
    * Parses the user command line interface and create a new [[io.vertx.scala.core.cli.CommandLine]] containing extracting values.
    * @param arguments the arguments
    * @param validate enable / disable parsing validation
    * @return the creates command line
    */
  def parse(arguments: scala.collection.mutable.Buffer[String],validate: Boolean):CommandLine = {
    CommandLine(asJava.asInstanceOf[JCLI].parse(arguments.map(x => x.asInstanceOf[java.lang.String]).asJava,validate.asInstanceOf[java.lang.Boolean]))
  }

  /**
    * @return the CLI name.
    */
  def getName():String = {
    asJava.asInstanceOf[JCLI].getName().asInstanceOf[String]
  }

  /**
    * @return the CLI description.
    */
  def getDescription():scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JCLI].getDescription().asInstanceOf[String])
  }

  /**
    * @return the CLI summary.
    */
  def getSummary():scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JCLI].getSummary().asInstanceOf[String])
  }

  /**
    * Checks whether or not the current [[io.vertx.scala.core.cli.CLI]] instance is hidden.
    * @return `true` if the current CLI is hidden, false otherwise
    */
  def isHidden():Boolean = {
    asJava.asInstanceOf[JCLI].isHidden().asInstanceOf[Boolean]
  }

  /**
    * Gets the list of options.
    * @return the list of options, empty if none.
    */
  def getOptions():scala.collection.mutable.Buffer[Option] = {
    asJava.asInstanceOf[JCLI].getOptions().asScala.map(x => Option(x))
  }

  /**
    * Gets the list of defined arguments.
    * @return the list of argument, empty if none.
    */
  def getArguments():scala.collection.mutable.Buffer[Argument] = {
    asJava.asInstanceOf[JCLI].getArguments().asScala.map(x => Argument(x))
  }

  /**
    * Gets an <a href="../../../../../../../cheatsheet/Option.html">Option</a> based on its name (short name, long name or argument name).
    * @param name the name, must not be `null`
    * @return the Option, `null` if not foundsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    */
  def getOption(name: String):scala.Option[Option] = {
    scala.Option(asJava.asInstanceOf[JCLI].getOption(name.asInstanceOf[java.lang.String])).map(Option(_))
  }

  /**
    * Gets an <a href="../../../../../../../cheatsheet/Argument.html">Argument</a> based on its name (argument name).
    * @param name the name of the argument, must not be `null`
    * @return the Argument, `null` if not found.see <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    */
  def getArgument(name: String):scala.Option[Argument] = {
    scala.Option(asJava.asInstanceOf[JCLI].getArgument(name.asInstanceOf[java.lang.String])).map(Argument(_))
  }

  /**
    * Gets an <a href="../../../../../../../cheatsheet/Argument.html">Argument</a> based on its index.
    * @param index the index, must be positive or zero.
    * @return the Argument, `null` if not found.see <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    */
  def getArgument(index: Int):scala.Option[Argument] = {
    scala.Option(asJava.asInstanceOf[JCLI].getArgument(index.asInstanceOf[java.lang.Integer])).map(Argument(_))
  }

}

object CLI{
  def apply(asJava: JCLI) = new CLI(asJava)  
  /**
    * Creates an instance of [[io.vertx.scala.core.cli.CLI]] using the default implementation.
    * @param name the name of the CLI (must not be `null`)
    * @return the created instance of CLI
    */
  def create(name: String):CLI = {
    CLI(JCLI.create(name.asInstanceOf[java.lang.String]))
  }

}

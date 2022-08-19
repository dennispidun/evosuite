/*
 * This file was automatically generated by EvoSuite
 * Thu Aug 18 23:22:40 GMT 2022
 */

package dimacs9;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import dimacs9.AproxBucket;
import dimacs9.VertexPulse;
import org.junit.runner.RunWith;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class AproxBucket_ESTest extends AproxBucket_ESTest_scaffolding {

  @Test(timeout = 11000)
  public void test00()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      int int0 = aproxBucket0.getUpperBound();
      assertEquals(Integer.MAX_VALUE, int0);
      assertEquals(1, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test01()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(57);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 57, Integer.MAX_VALUE);
      aproxBucket0.insertVertexDist(vertexPulse0);
      assertEquals(2147483591, aproxBucket0.getLowerBound());
      assertEquals((-59), aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test02()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(57);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 57, Integer.MAX_VALUE);
      aproxBucket0.turnTheBucketTime();
      assertEquals(2147483591, aproxBucket0.getLowerBound());
      assertEquals((-59), aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test03()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-486));
      AproxBucket aproxBucket0 = new AproxBucket((VertexPulse) null, (-486), Integer.MAX_VALUE);
      // Undeclared exception!
      try { 
        aproxBucket0.insertVertexTime(vertexPulse0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.AproxBucket", e);
      }
  }

  @Test(timeout = 11000)
  public void test04()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1532));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      int int0 = aproxBucket0.getKey();
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
      assertEquals(Integer.MAX_VALUE, int0);
      assertEquals(1, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test05()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      aproxBucket0.setUP(aproxBucket0);
      AproxBucket aproxBucket1 = aproxBucket0.deleteLabeledBucket();
      assertEquals(1, aproxBucket1.getLowerBound());
      assertNotNull(aproxBucket1);
      assertEquals(Integer.MAX_VALUE, aproxBucket1.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test06()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(57);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 57, Integer.MAX_VALUE);
      int int0 = aproxBucket0.getLowerBound();
      assertEquals((-59), aproxBucket0.getUpperBound());
      assertEquals(2147483591, int0);
  }

  @Test(timeout = 11000)
  public void test07()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(57);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 57, Integer.MAX_VALUE);
      aproxBucket0.getUP();
      assertEquals(2147483591, aproxBucket0.getLowerBound());
      assertEquals((-59), aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test08()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      aproxBucket0.deleteToPassTime(vertexPulse0);
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
      assertEquals(1, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test09()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(57);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 57, Integer.MAX_VALUE);
      aproxBucket0.turnTheBucket();
      assertEquals(2147483591, aproxBucket0.getLowerBound());
      assertEquals((-59), aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test10()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      aproxBucket0.getDown();
      assertEquals(1, aproxBucket0.getLowerBound());
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test11()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1532));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      aproxBucket0.deleteToPassDist(vertexPulse0);
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
      assertEquals(1, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test12()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(57);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 57, Integer.MAX_VALUE);
      aproxBucket0.deleteLabeledBucket();
      assertEquals(2147483591, aproxBucket0.getLowerBound());
      assertEquals((-59), aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test13()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-4));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, (-4), (-4));
      VertexPulse vertexPulse1 = new VertexPulse(Integer.MAX_VALUE);
      aproxBucket0.deleteToMoveDist(vertexPulse1);
      assertEquals(11, aproxBucket0.getUpperBound());
      assertEquals(16, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test14()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      VertexPulse vertexPulse1 = new VertexPulse(Integer.MAX_VALUE);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse1, Integer.MAX_VALUE, Integer.MAX_VALUE);
      aproxBucket0.deleteToMoveTime(vertexPulse0);
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
      assertEquals(1, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test15()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1532));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      aproxBucket0.deleteBucketToEmpty();
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
      assertEquals(1, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test16()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      aproxBucket0.setUP(aproxBucket0);
      AproxBucket aproxBucket1 = aproxBucket0.deleteBucketToEmpty();
      assertEquals(1, aproxBucket1.getLowerBound());
      assertEquals(Integer.MAX_VALUE, aproxBucket1.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test17()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(57);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 57, Integer.MAX_VALUE);
      aproxBucket0.deleteBucket();
      assertEquals((-59), aproxBucket0.getUpperBound());
      assertEquals(2147483591, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test18()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      aproxBucket0.setUP(aproxBucket0);
      aproxBucket0.deleteBucket();
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
      assertEquals(1, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test19()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      aproxBucket0.setUP(aproxBucket0);
      aproxBucket0.setDown(aproxBucket0);
      aproxBucket0.deleteBucket();
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
      assertEquals(1, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test20()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(Integer.MAX_VALUE);
      vertexPulse0.unlinkRighBoundDist();
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 0, 2841);
      // Undeclared exception!
      try { 
        aproxBucket0.deleteToMoveDist(vertexPulse0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.VertexPulse", e);
      }
  }

  @Test(timeout = 11000)
  public void test21()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(33);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 33, Integer.MAX_VALUE);
      vertexPulse0.unlinkRighBoundTime();
      // Undeclared exception!
      try { 
        aproxBucket0.deleteToMoveTime(vertexPulse0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.VertexPulse", e);
      }
  }

  @Test(timeout = 11000)
  public void test22()  throws Throwable  {
      AproxBucket aproxBucket0 = new AproxBucket((VertexPulse) null, (-1), (-1));
      // Undeclared exception!
      try { 
        aproxBucket0.deleteToPassDist((VertexPulse) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.AproxBucket", e);
      }
  }

  @Test(timeout = 11000)
  public void test23()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      // Undeclared exception!
      try { 
        aproxBucket0.deleteToPassTime((VertexPulse) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.AproxBucket", e);
      }
  }

  @Test(timeout = 11000)
  public void test24()  throws Throwable  {
      AproxBucket aproxBucket0 = new AproxBucket((VertexPulse) null, 1, 3638);
      // Undeclared exception!
      try { 
        aproxBucket0.insertVertexDist((VertexPulse) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.AproxBucket", e);
      }
  }

  @Test(timeout = 11000)
  public void test25()  throws Throwable  {
      AproxBucket aproxBucket0 = new AproxBucket((VertexPulse) null, 0, 0);
      // Undeclared exception!
      try { 
        aproxBucket0.turnTheBucket();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.AproxBucket", e);
      }
  }

  @Test(timeout = 11000)
  public void test26()  throws Throwable  {
      AproxBucket aproxBucket0 = new AproxBucket((VertexPulse) null, (-192), 0);
      // Undeclared exception!
      try { 
        aproxBucket0.turnTheBucketTime();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.AproxBucket", e);
      }
  }

  @Test(timeout = 11000)
  public void test27()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1824));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, (-1824), Integer.MAX_VALUE);
      aproxBucket0.setDown(aproxBucket0);
      AproxBucket aproxBucket1 = aproxBucket0.deleteBucket();
      assertEquals((-2147481826), aproxBucket1.getUpperBound());
      assertEquals(1824, aproxBucket1.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test28()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(0);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 0, Integer.MAX_VALUE);
      aproxBucket0.setDown(aproxBucket0);
      AproxBucket aproxBucket1 = aproxBucket0.deleteBucket();
      assertEquals(2147483646, aproxBucket1.getUpperBound());
      assertEquals(0, aproxBucket1.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test29()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(40);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 40, Integer.MAX_VALUE);
      aproxBucket0.setDown(aproxBucket0);
      AproxBucket aproxBucket1 = aproxBucket0.deleteBucket();
      assertEquals((-40), aproxBucket1.getLowerBound());
      assertEquals(2147483606, aproxBucket1.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test30()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, (-1546), Integer.MAX_VALUE);
      aproxBucket0.setUP(aproxBucket0);
      AproxBucket aproxBucket1 = aproxBucket0.deleteBucketToEmpty();
      assertEquals((-2147482104), aproxBucket1.getUpperBound());
      assertEquals(1546, aproxBucket1.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test31()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      AproxBucket aproxBucket1 = new AproxBucket(vertexPulse0, 1772, (-1546));
      aproxBucket0.setUP(aproxBucket1);
      AproxBucket aproxBucket2 = aproxBucket0.deleteBucketToEmpty();
      assertEquals((-2739512), aproxBucket2.getLowerBound());
      assertEquals((-2741059), aproxBucket2.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test32()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(0);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      AproxBucket aproxBucket1 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, 0);
      aproxBucket0.setUP(aproxBucket1);
      AproxBucket aproxBucket2 = aproxBucket0.deleteBucketToEmpty();
      assertEquals(0, aproxBucket2.getLowerBound());
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
      assertEquals(Integer.MAX_VALUE, aproxBucket2.getKey());
      assertEquals(1, aproxBucket0.getLowerBound());
      assertEquals((-1), aproxBucket2.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test33()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      AproxBucket aproxBucket1 = new AproxBucket(vertexPulse0, (-1546), 1);
      aproxBucket0.setUP(aproxBucket1);
      AproxBucket aproxBucket2 = aproxBucket0.deleteLabeledBucket();
      assertEquals((-1546), aproxBucket2.getLowerBound());
      assertEquals((-1546), aproxBucket2.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test34()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(336);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 336, 336);
      AproxBucket aproxBucket1 = new AproxBucket(vertexPulse0, 0, 0);
      aproxBucket0.setUP(aproxBucket1);
      AproxBucket aproxBucket2 = aproxBucket0.deleteLabeledBucket();
      assertEquals(112896, aproxBucket0.getLowerBound());
      assertEquals((-1), aproxBucket2.getUpperBound());
      assertEquals(113231, aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test35()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(1101);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 0, Integer.MAX_VALUE);
      VertexPulse vertexPulse1 = new VertexPulse(Integer.MAX_VALUE);
      vertexPulse0.setRigthDist(vertexPulse1);
      aproxBucket0.deleteToMoveDist(vertexPulse0);
      assertEquals(2147483646, aproxBucket0.getUpperBound());
      assertEquals(0, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test36()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(33);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 33, Integer.MAX_VALUE);
      VertexPulse vertexPulse1 = new VertexPulse(Integer.MAX_VALUE);
      aproxBucket0.insertVertexTime(vertexPulse1);
      aproxBucket0.deleteToMoveTime(vertexPulse0);
      assertEquals((-35), aproxBucket0.getUpperBound());
      assertEquals(2147483615, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test37()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1572));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      AproxBucket aproxBucket1 = new AproxBucket(vertexPulse0, (-1292), Integer.MAX_VALUE);
      aproxBucket0.setDown(aproxBucket1);
      AproxBucket aproxBucket2 = aproxBucket0.getDown();
      assertEquals(1292, aproxBucket2.getLowerBound());
      assertEquals((-2147482358), aproxBucket2.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test38()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(40);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 40, Integer.MAX_VALUE);
      aproxBucket0.setDown(aproxBucket0);
      AproxBucket aproxBucket1 = aproxBucket0.getDown();
      assertEquals((-40), aproxBucket1.getLowerBound());
      assertEquals(2147483606, aproxBucket1.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test39()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      vertexPulse0.setMinDist((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      aproxBucket0.getEntrance();
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
      assertEquals(1, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test40()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(33);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 33, (-2147483635));
      VertexPulse vertexPulse1 = vertexPulse0.getBLeftTime();
      vertexPulse1.minDist = 0;
      aproxBucket0.getEntrance();
      assertEquals((-2147483219), aproxBucket0.getLowerBound());
      assertEquals(441, aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test41()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(0);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, (-1824), 1669);
      aproxBucket0.getEntrance();
      assertEquals((-3042588), aproxBucket0.getUpperBound());
      assertEquals((-3044256), aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test42()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1394));
      vertexPulse0.setMaxDist((-1394));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, (-427), (-230));
      aproxBucket0.getEntrance();
      assertEquals(97979, aproxBucket0.getUpperBound());
      assertEquals(98210, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test43()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      vertexPulse0.maxDist = 1;
      aproxBucket0.getEntrance();
      assertEquals(1, aproxBucket0.getLowerBound());
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test44()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      vertexPulse0.setMaxTime((-1546));
      aproxBucket0.getEntrance();
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
      assertEquals(1, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test45()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(33);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 33, Integer.MAX_VALUE);
      vertexPulse0.setMaxTime(1);
      aproxBucket0.getEntrance();
      assertEquals((-35), aproxBucket0.getUpperBound());
      assertEquals(2147483615, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test46()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      vertexPulse0.setMinTime((-3995));
      aproxBucket0.getEntrance();
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
      assertEquals(1, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test47()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1540));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      vertexPulse0.minTime = 0;
      aproxBucket0.getEntrance();
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
      assertEquals(1, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test48()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(33);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 33, Integer.MAX_VALUE);
      vertexPulse0.setInsertedDist();
      aproxBucket0.getEntrance();
      assertEquals(2147483615, aproxBucket0.getLowerBound());
      assertEquals((-35), aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test49()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      vertexPulse0.setInsertedTime();
      aproxBucket0.getEntrance();
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
      assertEquals(1, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test50()  throws Throwable  {
      AproxBucket aproxBucket0 = new AproxBucket((VertexPulse) null, 160, 60);
      aproxBucket0.getEntrance();
      assertEquals(9600, aproxBucket0.getLowerBound());
      assertEquals(9659, aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test51()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, (-1546), (-1546));
      int int0 = aproxBucket0.getKey();
      assertEquals(2390116, aproxBucket0.getLowerBound());
      assertEquals(2388569, aproxBucket0.getUpperBound());
      assertEquals((-1546), int0);
  }

  @Test(timeout = 11000)
  public void test52()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(1101);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 0, Integer.MAX_VALUE);
      int int0 = aproxBucket0.getKey();
      assertEquals(0, int0);
      assertEquals(2147483646, aproxBucket0.getUpperBound());
      assertEquals(0, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test53()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(40);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 40, Integer.MAX_VALUE);
      int int0 = aproxBucket0.getLowerBound();
      assertEquals(2147483606, aproxBucket0.getUpperBound());
      assertEquals((-40), int0);
  }

  @Test(timeout = 11000)
  public void test54()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(0);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, 0, Integer.MAX_VALUE);
      int int0 = aproxBucket0.getLowerBound();
      assertEquals(0, int0);
      assertEquals(2147483646, aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test55()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      AproxBucket aproxBucket1 = new AproxBucket(vertexPulse0, (-567), (-1546));
      aproxBucket0.setUP(aproxBucket1);
      AproxBucket aproxBucket2 = aproxBucket0.getUP();
      assertEquals(875035, aproxBucket2.getUpperBound());
      assertEquals(876582, aproxBucket2.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test56()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, (-1546), Integer.MAX_VALUE);
      AproxBucket aproxBucket1 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, (-1546));
      aproxBucket0.setUP(aproxBucket1);
      AproxBucket aproxBucket2 = aproxBucket0.getUP();
      assertEquals(1546, aproxBucket2.getLowerBound());
      assertNotSame(aproxBucket2, aproxBucket0);
      assertEquals((-2147482104), aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test57()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, Integer.MAX_VALUE, Integer.MAX_VALUE);
      AproxBucket aproxBucket1 = new AproxBucket(vertexPulse0, 1772, (-1546));
      aproxBucket0.setUP(aproxBucket1);
      AproxBucket aproxBucket2 = aproxBucket0.getUP();
      assertEquals((-2741059), aproxBucket2.getUpperBound());
      assertEquals((-2739512), aproxBucket2.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test58()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, (-1546), Integer.MAX_VALUE);
      int int0 = aproxBucket0.getUpperBound();
      assertEquals((-2147482104), int0);
      assertEquals(1546, aproxBucket0.getLowerBound());
  }

  @Test(timeout = 11000)
  public void test59()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1546));
      VertexPulse vertexPulse1 = new VertexPulse(Integer.MAX_VALUE);
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse1, Integer.MAX_VALUE, Integer.MAX_VALUE);
      aproxBucket0.deleteToMoveDist(vertexPulse0);
      assertEquals(1, aproxBucket0.getLowerBound());
      assertEquals(Integer.MAX_VALUE, aproxBucket0.getUpperBound());
  }

  @Test(timeout = 11000)
  public void test60()  throws Throwable  {
      long start = System.currentTimeMillis();
      VertexPulse vertexPulse0 = new VertexPulse((-4));
      AproxBucket aproxBucket0 = new AproxBucket(vertexPulse0, (-4), (-4));
      VertexPulse vertexPulse1 = new VertexPulse(Integer.MAX_VALUE);
      aproxBucket0.deleteToMoveTime(vertexPulse1);
      assertEquals(11, aproxBucket0.getUpperBound());
      assertEquals(16, aproxBucket0.getLowerBound());
  }
}

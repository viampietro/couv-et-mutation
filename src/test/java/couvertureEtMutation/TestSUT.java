package couvertureEtMutation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

class TestSUT {


	@Test
	void testAjoutDe5√©l√©ments() throws TableauPleinException {
		SUT sut=new SUT(5);
		sut.ajout(1);
		sut.ajout(2);
		sut.ajout(3);
		sut.ajout(4);
		sut.ajout(5);
		int[] tab=sut.values();
		int[] expected = {1,2,3,4,5};
		assertArrayEquals(expected,tab);
		assertEquals(5,sut.values().length);
	}

	@Test 
	void testExceptionQuandAjoutDansTableauPlein() throws TableauPleinException {
		SUT sut=new SUT(3);
		sut.ajout(1);
		sut.ajout(2);
		sut.ajout(3);
		assertThrows(TableauPleinException.class, ()->{sut.ajout(4);});
	}
	
	@Test
	void testMinTableauRempliTri√©() throws TableauPleinException, TableauVideException {
		SUT sut=new SUT(3);
		sut.ajout(1);
		sut.ajout(2);
		sut.ajout(3);
		assertEquals(1, sut.retourneEtSupprimePremiereOccurenceMin());
		assertFalse(ArrayUtils.contains(sut.values(), 1));
		assertEquals(2,sut.values().length);
	}

	@Test
	void testMinTableauRempliNonTri√©() throws TableauPleinException, TableauVideException {
		SUT sut=new SUT(3);
		sut.ajout(5);
		sut.ajout(1);
		sut.ajout(2);
		assertEquals(1,sut.retourneEtSupprimePremiereOccurenceMin());
		assertFalse(ArrayUtils.contains(sut.values(), 1));
		assertEquals(2,sut.values().length);
	}
	
	@Test
	void testMinTableauRempliNonTrie2() throws TableauPleinException, TableauVideException {
		SUT sut = new SUT(3);
		sut.ajout(2);
		sut.ajout(5);
		sut.ajout(2);
		assertEquals(2, sut.retourneEtSupprimePremiereOccurenceMin());
		assertEquals(5, sut.values()[0]);
		assertEquals(2, sut.values().length);
	}
	
	@Test
	void testMinTableauVide() {
		SUT sut=new SUT(3);
		assertThrows(TableauVideException.class, ()->{sut.retourneEtSupprimePremiereOccurenceMin();});
	}
	
}

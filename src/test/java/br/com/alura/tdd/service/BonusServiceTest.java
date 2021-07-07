package br.com.alura.tdd.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusServiceTest {
	
	@Test
	public void testarCalculoBonus() {
		LocalDate dt = LocalDate.of(2021, Month.MARCH, 15);
		Funcionario funcionario = new Funcionario("Vitor Oliveira",dt , BigDecimal.valueOf(900));
		BonusService bonusService = new BonusService();
		BigDecimal valor = bonusService.calcularBonus(funcionario);
		assertEquals(new BigDecimal("90.00"), valor );
	}
	
	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		assertThrows(IllegalArgumentException.class,() -> service.calcularBonus(new Funcionario("Vitor Oliveira", LocalDate.now(), new BigDecimal(25000))));
	}
	
}

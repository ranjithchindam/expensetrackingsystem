package configurations;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.assignment.expensetrackingsystem.dao.Expensedao;

@AutoConfiguration
public class ConfigurationsClass {
	  @Bean
	   public ModelMapper modelMapper()
	   {
		   return new ModelMapper();
	   }
	  @Bean
	  public Expensedao expenseDao()
	  {
		  return new Expensedao();
	  }
}

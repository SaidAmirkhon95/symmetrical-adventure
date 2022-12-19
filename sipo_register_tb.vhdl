library ieee;
use ieee.std_logic_1164.all;

entity sipo_register_tb is 
end sipo_register_tb;

architecture rtl of sipo_register_tb is

    component sipo_register 
         port(
		     serial_in, clear, clock : in std_logic;
			 Q : out std_logic_vector(3 downto 0)
		 );     
    end component;
	
	signal serial_in, clear, clock : std_logic;
	signal Q : std_logic_vector(3 downto 0);
begin
    
	
	sipo_reg_instance : sipo_register port map (serial_in => serial_in, clear => clear, clock => clock, Q => Q);

    process begin
       -- SIPO initialisieren indem man es zurueck setzt
        clock <= '0'; 
        clear <= '0';
        serial_in <= '0';
        wait for 10 ns;
        --Zuruecksetzen.
        clear <= '1';
        clock <= '1';
        
        wait for 10 ns;
        clock <= '0'; 
        clear <= '0';
        wait for 10 ns;

        --Uebergebe die Bitsequenz 1000 
        --erstes Bit
        serial_in <= '1';
        clock <= '1';
        wait for 10 ns;
        clock <= '0'; 
        wait for 10 ns; 
        --weitere Bits
        --vervollstandigen
             
        --Pause, nichts aendert sich
        wait for 30 ns; 
        --Zuruecksetzen.
        clear <= '1';
        clock <= '1';
        serial_in <= '0';
        wait for 10 ns;
        clock <= '0'; 
        clear <= '0';
        wait for 10 ns;
        
        --Uebergebe weite Bitsequenz 
        
        wait;
    end process; 
    
end rtl; 

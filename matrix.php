<?php


$matrix = array (

    array('1','2','3','4','5'),
    array('6','7','8','9','0'),
    array('A','B','C','D','E'),
    array('F','G','H','I','J'),
    array('K','L','M','N','O'),
    array('P','Q','R','S','T'),

);


$m = 0;
$n = 0;
$d = 1;

$e ="\n";

$total_elements = 0;
$rows = 0;
foreach($matrix as $elements){

	
    $total_elements = $total_elements + count($elements);
    $rows++;
}

$printed_elements = 0;
$layers = 0;

//echo $e."No of Rows[".$rows."]";
   

while($printed_elements < $total_elements){

    //echo $e."Cur row[".$layers."]";
    
    if($layers == 4){
      echo $e."Going to break".$e;
      exit;
     }

    $processed_element = completeRound($rows,$layers,$matrix);
    //echo $e."=> ".$processed_element." t=> ".$total_elements.$e;
    $printed_elements = $printed_elements + $processed_element;
    $layers++;
    
    
	
}


function completeRound($rows,$layer,$matrix){

	global $e;

	$bottom_str = "";
	$top_str = "";
	$upward_str = "";
	$downward_str = "";
    $cnt = 0;

	//Going ===> direction
	//Going <=== direction 

	$start = $layer;
	$end = count($matrix[$layer])-$layer;
		
    $rev_end = $end-1;
	$bot_array = array($end);

    
    //echo $e."Start is [".$start."] End is [".$end."] RevEnd[".$rev_end."]";

	for($ind=$start; $ind < $end; $ind++){

		 $val = $matrix[$layer][$ind];	
		 //echo $e.$val;
		 $top_str .= $val." "; 	
		 
		 $cnt++;

         
         $bot_m_ind = $rows - ($layer + 1);
         
		 $bot_array[$ind] = $matrix[$bot_m_ind][$rev_end];
		 $val = $matrix[$bot_m_ind][$rev_end];
		 $bottom_str .= $val." ";
		 //echo $e.$bot_array[$ind]." : bot_array[".$rev_end."] = matrix[".$bot_m_ind."][".$rev_end."]";
		 $cnt++;
		 $rev_end--;
	}
    
    /*echo $e;
   // print_r($bot_array);
    echo $e;
    //print_r($top_str);
    //print_r($bottom_str);
    echo $e;*/
    
    $start =  $layer + 1 ;
    $end   =  $rows - $start;
    
    
    $rev_end = $end - 1;
    
    
    for($ind = $start; $ind < $end; $ind++){
         
         
         $val = $matrix[$rev_end][$layer];
         
         //echo $e."End ".$end." Ind ".$ind." Value is ".$val." = matrix[".$rev_end."][".$layer."]; ";
         $rev_end--;
         $upward_str .= $val." ";
         $cnt++;
         
         
         
         
         $last_ind = ( count($matrix[$ind]) - 1 ) - $layer;
         
         $val = $matrix[$ind][$last_ind];
         $downward_str .= $val." ";
         $cnt++;
         
         
         
          
    }
    
    //echo $e;
    
    
    
    
    print_r($top_str);
    print_r($downward_str);
    print_r($bottom_str);
    print_r($upward_str);
    
    echo $e;
    
	return $cnt;

}


?>

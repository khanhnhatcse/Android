<?php
    // Cong thức Haversine 
    $A = $_GET["point1"];
    $B = $_GET["point2"];
    $R = 6371;
    $dLat = $A[0] - $B[0];
    $dLon = $A[1] - $B[1];
    $delta = sin($dLat / 2 ) * sin($dLat /2 ) 
    + cos(deg2rad(floatval($A[0]))) * cos(deg2rad(floatval($B[0]))) 
    * sin($dLon / 2) * sin($dLon /2);
    $distance = $R * 2 * atan2(sqrt($delta) , sqrt(1 - $delta));
    $return = array("distance" => $distance);
    echo json_encode($return);
?>
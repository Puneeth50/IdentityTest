@GetVehicleDetails
 Feature: As a vehicle holder, I want to see my Vehicle reg details in DVLA website

   Scenario:
     Given I load vehicle registration details from the file
     When I am on DVLA get vehicle information web page
     Then I see vehicle details are displayed as expected

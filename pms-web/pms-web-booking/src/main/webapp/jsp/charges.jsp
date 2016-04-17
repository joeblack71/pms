<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/stylesheet.css">
<title>JSP Page</title>
</head>
<body>

<!--<h1>JSP Page</h1>-->

<form name='charge' action=''>
<table width='640' class='Form'>
    <caption class='Form'>Room Number #</caption>
    <tr>
        <td><label for='room'>Room</label>
        <td><select name='room' class='Medium' id='room'>
            <option>1001</option>
        </select> <label for='roombalance'>&nbsp;&nbsp;&nbsp;&nbsp;Balance</label>
        <input type='text' name='roombalance' readonly class='Large'
            id='roombalance'>

        <tr>
            <td><label for='guest'>Guest Account</label>
            <td><select name='guest' class='XLarge' id='guest'>
                <option>Room Guest # 1</option>
            </select> <!--<label for='acctbalance'>Account Balance</label>
                    <input type='text' name='acctbalance' readonly
                           class='Medium' id='acctbalance'>-->

            <tr>
                <td colspan='2'>&nbsp;

                <tr>
                    <td colspan='2'>
                    <table rules='groups'>
                        <colgroup>
                            <col class='Tiny'>
                            <colgroup>
                                <col class='Medium Center'>
                                <col class='XLarge'>
                                <col class='Medium Number'>
                                <col class='Medium Center'>
                                <col class='Small Center'>

                                <thead>
                                    <tr>
                                        <th>&nbsp;
                                        <th>Date
                                        <th>Detail
                                        <th>Amount
                                        <th>Document
                                        <th>Cashier
                                        <tbody>
                                            <tr>
                                                <td><input
                                                    type='checkbox'
                                                    class='NoBorder'>
                                                <td>15/04/07
                                                <td>Restaurante
                                                <td>25.15
                                                <td>C/8594
                                                <td>JO.
                                                <tr class='Distinct'>
                                                    <td><input
                                                        type='checkbox'
                                                        class='NoBorder'>
                                                    <td>15/04/07
                                                    <td>Alojamiento
                                                    <td>115.20
                                                    <td>14/04
                                                    <td>S.E
                                                    <tr>
                                                        <td><input
                                                            type='checkbox'
                                                            class='NoBorder'>
                                                        <td>14/04/07
                                                        <td>Lavanderia
                                                        <td>35.25
                                                        <td>V/4512
                                                        <td>S.E</td>
                                                        </td>
                                                        </td>
                                                        </td>
                                                        </td>
                                                        </td>
                                                    </tr>
                                                    </td>
                                                    </td>
                                                    </td>
                                                    </td>
                                                    </td>
                                                    </td>
                                                </tr>
                                                </td>
                                                </td>
                                                </td>
                                                </td>
                                                </td>
                                                </td>
                                            </tr>
                                        </tbody>
                                        </th>
                                        </th>
                                        </th>
                                        </th>
                                        </th>
                                        </th>
                                    </tr>
                                </thead>
                            </colgroup>
                        </colgroup>
                    </table>

                    <tr>
                        <td colspan='2'>&nbsp;

                        <tr>
                            <td colspan='2' align='center'><input
                                type='submit' name='add' value='Add'
                                class='MediumButton'> <input
                                type='submit' name='correct'
                                value='Correct' class='MediumButton'>
                            <input type='submit' name='transfer'
                                value='Transfer' class='MediumButton'>
                            <input type='submit' name='print'
                                value='Print' class='MediumButton'>
                            <input type='submit' name='checkout'
                                value='C/O' class='MediumButton'>

                            <tr>
                                <td colspan='2'>&nbsp;</td>
                            </tr>
                            </td>
                        </tr>
                        </td>
                    </tr>
                    </td>
                </tr>
                </td>
            </tr>
            </td>
            </td>
        </tr>
        </td>
        </td>
    </tr>
</table>
</form>

</body>
</html>

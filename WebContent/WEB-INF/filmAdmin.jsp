<form method="POST" action="<c:url value="/admin/filmAdmin" />">
    <input name="titre" type="text"></input>
    <input name="budget" type="text"></input>
    <input name="anneeProduction" type="text"></input>
    <input name="synopsis" type="text"></input>
    <select name="metrage">
        <option  value="court">court</option>
        <option  value="moyen">moyen</option>
        <option  value="long">long</option>
    </select>
    <input name="urlAffiche" type="text"></input>
    <input name="isan" type="text"></input>

    <select name="age">
        <option  value="10">10</option>
        <option  value="12">12</option>
        <option  value="16">16</option>
        <option  value="18">18</option>
    </select>
    <input type="submit"></input>
</form>

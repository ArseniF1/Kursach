package com.hfad.kursach;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import org.ejml.data.Complex64F;
import org.ejml.data.DenseMatrix64F;
import org.ejml.factory.DecompositionFactory;
import org.ejml.interfaces.decomposition.EigenDecomposition;
import android.text.TextUtils;






public class ChemicalBalance extends Activity {

    double Kw = 1E-14;
    double answer;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical_balance);

        Spinner spinner = (Spinner) findViewById(R.id.acidslist);
        ArrayAdapter<Acid> adapter = new ArrayAdapter<Acid>(this, android.R.layout.simple_spinner_dropdown_item, Acid.acids);
        spinner.setAdapter(adapter);

    }


    public void onActionClicked(View v) {
        Spinner spinner = (Spinner) findViewById(R.id.acidslist);
        //Всё работает, значит можно использовать getSelectedItem() и приводить к (Acid)
        Acid acid = (Acid) spinner.getSelectedItem();
        TextView view = (TextView) findViewById(R.id.answer);
        EditText concentration = (EditText) findViewById(R.id.concentration);
        Double conc = Double.parseDouble(concentration.getText().toString());
        double answer = conc * acid.getKa1() * Kw;
        String b = String.valueOf(answer);


        Complex64F[] c = findRoots(-9 * acid.getKa1() * acid.getKa2() * acid.getKa3() * conc , (-6 * acid.getKa1() * acid.getKa2() * conc) + (3 * acid.getKa1() * acid.getKa2() * acid.getKa3()) , -Kw - (acid.getKa1() * 3 * conc) + (2 * acid.getKa1() * acid.getKa2()), acid.getKa1(), 1);
        Complex64F f0 = c[0];

        // Без этой строчки android выводит непонятные конструкции(ошибки)
            view.setText(f0.toString());
            Double a =Double.parseDouble(view.getText().toString());
            double o = -1 * Math.log10(a);
            String m = String.valueOf(o);
        view.setText(m);


        }





    public static Complex64F[] findRoots(double... coefficients) {
        int N = coefficients.length-1;

        // Construct the companion matrix
        DenseMatrix64F c = new DenseMatrix64F(N,N);

        double a = coefficients[N];
        for( int i = 0; i < N; i++ ) {
            c.set(i,N-1,-coefficients[i]/a);
        }
        for( int i = 1; i < N; i++ ) {
            c.set(i,i-1,1);
        }

        //decomposition to find the roots
        EigenDecomposition<DenseMatrix64F> evd =  DecompositionFactory.eig(N,false);

        evd.decompose(c);

        Complex64F[] roots = new Complex64F[N];

        for( int i = 0; i < N; i++ ) {
            roots[i] = evd.getEigenvalue(i);
        }

        return roots;
    }


}

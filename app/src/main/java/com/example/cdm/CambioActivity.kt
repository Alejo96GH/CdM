package com.example.cdm

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.cdm.utils.Constantes.Companion.Dolar
import com.example.cdm.utils.Constantes.Companion.Euro
import com.example.cdm.utils.Constantes.Companion.INTERLIN
import com.example.cdm.utils.Constantes.Companion.Libra
import com.example.cdm.utils.Constantes.Companion.SPACE
import kotlinx.android.synthetic.main.activity_visual.*


class CambioActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visual)
        var moneda = "Dólar"
        var base : Float  = 3386.00F
        var ValorP : Float  = 0.0F
        var ValorD : Float  = 0.0F
        var ValorE : Float  = 0.0F
        var ValorL : Float  = 0.0F


        rb_dolar.setOnClickListener{
            moneda = "Dólar estadounidense"
            base = Dolar
        }

        rb_euro.setOnClickListener{
            moneda = "Euro"
            base = Euro
        }

        rb_libra.setOnClickListener{
            moneda = "Libra esterlina"
            base = Libra
        }

        rb_peso.setOnClickListener{
            moneda = "Peso Colombiano"
            base = 1F
        }

        bt_cambio.setOnClickListener {

            var valor :String = et_valor.text.toString()


            if (valor.isEmpty()) {
                Toast.makeText( this, "Coloque el valor", Toast.LENGTH_SHORT).show()
            }
            else{
                ValorP = base*valor.toFloat()
                ValorD = ValorP/Dolar
                ValorE = ValorP/Euro
                ValorL = ValorP/Libra
                if (base==Dolar){
                    tv_resultado.text =
                        getString(R.string.moneda_lb) + SPACE  + moneda + INTERLIN + INTERLIN +
                                getString(R.string.euro_lb) + SPACE  + ValorE + INTERLIN + INTERLIN +
                                getString(R.string.libra_lb) + SPACE  + ValorL + INTERLIN + INTERLIN +
                                getString(R.string.peso_lb) + SPACE  + ValorP
                }
                else if (base==Euro){
                    tv_resultado.text =
                        getString(R.string.moneda_lb) + SPACE  + moneda + INTERLIN +  INTERLIN +
                                getString(R.string.dolar_lb) + SPACE  + ValorD + INTERLIN +  INTERLIN +
                                getString(R.string.libra_lb) + SPACE  + ValorL + INTERLIN +  INTERLIN +
                                getString(R.string.peso_lb) + SPACE  + ValorP
                }
                else if (base==Libra){
                    tv_resultado.text =
                        getString(R.string.moneda_lb) + SPACE  + moneda + INTERLIN +  INTERLIN +
                                getString(R.string.dolar_lb) + SPACE  + ValorD + INTERLIN +  INTERLIN +
                                getString(R.string.euro_lb) + SPACE  + ValorE + INTERLIN +  INTERLIN +
                                getString(R.string.peso_lb) + SPACE  + ValorP
                }
                if (base==1F){
                    tv_resultado.text =
                        getString(R.string.moneda_lb) + SPACE  + moneda + INTERLIN +  INTERLIN +
                                getString(R.string.dolar_lb) + SPACE  + ValorD + INTERLIN +  INTERLIN +
                                getString(R.string.euro_lb) + SPACE  + ValorE + INTERLIN +  INTERLIN +
                                getString(R.string.libra_lb) + SPACE  + ValorL
                }
            }
        }
    }
}
<template>
    <div id = "app">
        <div v-for ="emergencia of emergencias" :key="emergencia.id_emergency" >
            <!--STARJETA DE EMERGENCIA-->
            <v-card id="tarjetaEmergencia" class="mx-auto" max-width="100%">
                <v-toolbar id ="barra" >
                    <v-toolbar-title id ="barraEmergencia" >Emergencia: {{emergencia.name}}</v-toolbar-title>
                </v-toolbar>
                <!--SECCION DEL TOTAL DE TAREAS-->
                <v-list subheader three-line>
                    <v-list-item >
                        <v-list-item-content>
                        <v-list-item-title>Tareas asignadas</v-list-item-title>
                            <div v-for ="total of listaTotales" :key="total.f_id">
                                <v-list-item-subtitle v-if ="total.f_id == emergencia.id_emergency" v-once> 
                                    cantidad: {{total.f_total}}
                                </v-list-item-subtitle>    
                            </div>           
                        </v-list-item-content>
                    </v-list-item>
                 </v-list>
                <v-divider></v-divider>
                <!--SECCION DEL ESTADO DE LA EMERGENCIA-->
                <v-list subheader three-line>
                    <v-subheader>Estado actual</v-subheader>
                    <v-list-item id = "listaEstado">
                        <template v-slot:default="{ active }">
                            <v-list-item-action>
                            <v-checkbox :input-value="active" v-model="emergencia.estado" @click="putStatus(emergencia.id_emergency)"></v-checkbox>
                            </v-list-item-action>
                            <v-list-item-content>
                            <v-list-item-title v-if="emergencia.estado == true">Activa</v-list-item-title>
                            <v-list-item-title v-if="emergencia.estado == false">Inactiva</v-list-item-title>
                            <v-list-item-subtitle></v-list-item-subtitle>
                            </v-list-item-content>
                        </template>
                    </v-list-item>
                </v-list>
            </v-card>
        </div>
    </div>
</template>
<script>
export default{
      data () {
        return{
            emergencias:[],
            listaTotales:[]     
         }
      },
      methods:{
        getData: async function(){
           try {
               let response = await this.$axios.get('/emergencies');
               let response2 = await this.$axios.get('/totalTasks');
               this.listaTotales = response2.data;
               this.emergencias  = response.data;     
               console.log(response)
           } catch (error) {
               console.log('error', error);
           }
       },
       putStatus: async function(id){
            try { 
               let response = await this.$axios.post('/emergencies/changeState/'+ id);
               console.log(response)
           } catch (error) {
               console.log('error', error);
           }    
       }
     
 },
   //Función que se ejecuta al cargar el componente
   created:function(){
       this.getData();
      }
    }
  </script>
<style>
 #app{
     background-color:#aed6f1;
 }
 #barraEmergencia{
     color: white ;
     
 }
 #barra{
    background-color:    #2980b9;
 }
#tarjetaEmergencia{
    margin-bottom: 1.5%;
    
}
  </style>
